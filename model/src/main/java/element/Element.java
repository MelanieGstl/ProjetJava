package element;

import java.awt.Image;

public class Element {
	private Permeability permeability;
	//private INettleWorld	nettleWorld;
	
	public Element( final Permeability permeability) {
		this.setPermeability(permeability);
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
	
}
