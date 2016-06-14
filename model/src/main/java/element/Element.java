package element;

import java.awt.Image;

import contract.IModel;

public class Element {
	private Permeability permeability;
	private IModel	model;
	
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
	
	public IModel getModel(){
		return this.model;
	}
	
}