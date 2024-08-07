package kirjanpito.models;

import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;

import kirjanpito.ui.Kirjanpito;

public class DataSourceInitializationModel {
	private static final String MODELS_PATH = "tilikarttamallit/";
	private Logger logger = Logger.getLogger(Kirjanpito.LOGGER_NAME);
	private Map<String, String> modelNameToDir;

	public DataSourceInitializationModel() {
		modelNameToDir = new HashMap<>();
	}

	public void update() {
		modelNameToDir.clear();
		try {
			URI uri = getClass().getResource("/" + MODELS_PATH).toURI();
			if (uri.getScheme().equals("jar")) {
				JarURLConnection jarURLConnection = (JarURLConnection) uri.toURL().openConnection();
				try (JarFile jar = jarURLConnection.getJarFile()) {
					jar.stream()
							.filter(entry -> entry.getName().startsWith(MODELS_PATH)
									&& entry.getName().endsWith("/model.properties"))
							.forEach(entry -> processModelProperties(entry.getName()));
				}
				
			} else {
				Path path = Paths.get(uri);
				try (Stream<Path> stream = Files.list(path)) {
					stream.filter(Files::isDirectory)
							.forEach(dir -> processModelProperties(
									"/" + MODELS_PATH + "/" + dir.getFileName().toString() + "/model.properties"));
				}
			}
		} catch (URISyntaxException | IOException e) {
			logger.log(Level.WARNING, "Tilikarttamallien hakeminen epäonnistui", e);
		}
	}

	private void processModelProperties(String resourcePath) {
		String path = resourcePath.startsWith("/") ? resourcePath : "/" + resourcePath;
		try (InputStream input = getClass().getResourceAsStream(path)) {
			if (input == null) {
				throw new IOException("Resource not found: " + path);
			}
			Properties props = new Properties();
			props.load(input);
			String name = props.getProperty("name");
			if (name == null) {
				throw new IOException("Tilikarttamallin " + path + " nimi puuttuu");
			}
			modelNameToDir.put(name, path.substring(0, path.lastIndexOf("/")));
		} catch (IOException e) {
			logger.log(Level.WARNING, "Tilikarttamallin " + path + " lukeminen epäonnistui", e);
		}
	}

	public int getModelCount() {
		return modelNameToDir.size();
	}

	public String[] getModelNames() {
		return modelNameToDir.keySet().toArray(new String[0]);
	}

	public InputStream getModelFileAsStream(String modelName, String fileName) {
		InputStream result = getClass().getResourceAsStream(modelNameToDir.get(modelName) + "/" + fileName);
		if (result == null) {
			throw new IllegalArgumentException("Tilikarttamallia ei löydy: " + modelName + " -> "
					+ modelNameToDir.get(modelName) + "/" + fileName);
		}
		return result;
	}
}