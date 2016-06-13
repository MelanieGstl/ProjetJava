package element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.imageio.ImageIO;

public class Sprite extends StringWriter {
	private Image image;

	public Sprite(final String c, final String image) {
		this.write(c);
		try {
			this.image = ImageIO.read(new File("sprite/" + image));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jpu2016.nettle.world.element.ISprite#getImage()
	 */
	
	public Image getImage() {
		return this.image;
	}
}
