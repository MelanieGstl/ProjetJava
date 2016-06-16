
package element;

import java.awt.Point;

import model.Model;

public class Monster{
	
	private int x;
	private int y;
	private int death;
	
	public Monster(int x, int y)
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
	
	public int getDeath()
	{
		return this.death;
	}
	
	public void setDeath(int death)
	{
		this.death = death;
	}
	
}
