package element;

import java.awt.Image;

public class Element {
	private Sprite sprite;
	private Permeability permeability;
	//private INettleWorld	nettleWorld;
	
	public Element(final Sprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	private void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}
	
	public Permeability getPermeability() {
		return this.permeability;
	}
	
	private void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}
	
	/*protected INettleWorld getNettleWorld() {
		return this.nettleWorld;
	}
	
	public void setNettleWorld(final INettleWorld nettleWorld) {
		this.nettleWorld = nettleWorld;
	}*/
	
	public Image getImage() {
		return this.getSprite().getImage();
	}	
	
}
