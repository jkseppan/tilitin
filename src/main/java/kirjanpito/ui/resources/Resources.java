package kirjanpito.ui.resources;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import java.awt.Image;

/**
 * <code>Resources</code>-luokan avulla voidaan lukea
 * JAR-pakettiin tallennettuja resurssitiedostoja,
 * esimerkiksi käyttöliittymässä tarvittavia kuvakkeita.
 * 
 * @author tommi
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
}
