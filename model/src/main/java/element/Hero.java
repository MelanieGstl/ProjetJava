
package element;

import java.awt.Point;

public class Hero{
	
	public int x;
	public int y;
	
	public Hero(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	/*private boolean isMovePossible(final int x, final int y) {
		if(model.getElement(x, y) == 'h' || this.getModel().getElement(x, y) == 'v' || this.getModel().getElement(x, y) == 'b'){
			return false;
		}else{
			return true;
		}
	}*/
	
	public void moveUp() {
		this.setY(this.getY() - 1);
	}

	public void moveLeft() {
		this.setX(this.getX() - 1);
	}

	public void moveDown() {
		this.setY(this.getY() + 1);
	}

	public void moveRight() {
		this.setX(this.getX() + 1);
	}
	
}
