package element;

import java.awt.Point;

public class Mobile {
	
	private int y;
	
	public void moveUp(int y)
	{
		this.setY(this.getY() - 1);
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
}
