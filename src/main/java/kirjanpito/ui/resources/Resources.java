package kirjanpito.ui.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import java.awt.Image;

/**
 * <code>Resources</code>-luokan avulla voidaan lukea
 * JAR-pakettiin tallennettuja resurssitiedostoja,
 * esimerkiksi käyttöliittymässä tarvittavia kuvakkeita.
 * 
 * @author tommi
 * @author jkseppan
 */
public class Resources {
	private Resources() {}
	
	/**
	 * Palauttaa resurssitiedoston <code>filename</code>
	 * tiedostovirran.
	 * 
	 * @param filename tiedoston nimi
	 * @return tiedostovirta
	 */
	public static InputStream loadAsStream(String filename) {
		return Resources.class.getClassLoader().getResourceAsStream(filename);
	}

	public static Image loadAsImage(String filename) {
		try {
			return ImageIO.read(Resources.loadAsStream(filename));
		}
		catch (IOException e) {
			System.err.println("Error loading image: " + filename);
			e.printStackTrace();
			return null;
		}
	}

	public static String loadAsString(String filename) {
		try (InputStream is = Resources.loadAsStream(filename);
			 BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
			return sb.toString();
		}
		catch (IOException e) {
			System.err.println("Error loading string: " + filename);
			e.printStackTrace();
			return null;
		}
	}
}
