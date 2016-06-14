package element;

import java.awt.Point;

public class Mobile extends Element {
	private final Point position;

	public Mobile() {
		super(Permeability.BLOCKING);
		this.position = new Point();
	}
	
	public int getX() {
		return this.position.x;
	}

	protected void setX(final int x) {
		if ((x >= 0) && (x < this.getModel().getWidth())) {
			this.position.x = x;
			this.getModel().setMobileHasChanged();
		}
	}
	
	public int getY() {
		return this.position.y;
	}

	protected void setY(final int y) {
		if ((y >= 0) && (y < this.getModel().getHeight())) {
			this.position.y = y;
			this.getModel().setMobileHasChanged();
		}
	}

	public Point getPosition() {
		return this.position;
	}

	/*public void setNettleWorld(final INettleWorld nettleWorld, final int x, final int y) {
		super.setNettleWorld(nettleWorld);
		this.setX(x);
		this.setY(y);
	}*/

	private boolean isMovePossible(final int x, final int y) {
		if(this.getModel().getElement(x, y) == 'h' || this.getModel().getElement(x, y) == 'v' || this.getModel().getElement(x, y) == 'b'){
			return false;
		}else{
			return true;
		}
		
		
		//return (this.getNettleWorld().getElements(x, y).getPermeability() != Permeability.BLOCKING);
	}

	public void moveUp() {
		if (this.isMovePossible(this.getX(), this.getY() - 1)) {
			this.setY(this.getY() - 1);
		}
	}

	public void moveLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY())) {
			this.setX(this.getX() - 1);
		}
	}

	public void moveDown() {
		if (this.isMovePossible(this.getX(), this.getY() + 1)) {
			this.setY(this.getY() + 1);
		}
	}

	public void moveRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY())) {
			this.setX(this.getX() + 1);
		}
	}
	
}
