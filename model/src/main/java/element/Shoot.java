
package element;

import java.awt.Point;

import model.Model;

/**
 * The Class Shoot.
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 *
 */
public class Shoot{
	
	private int x;
	private int y;
	private String fireDirection = "RIGHT";	
	
	public Shoot(int x, int y)
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
	
	public void moveDiagoHD() {
		this.setX(this.getX() + 1);
		this.setY(this.getY() - 1);
	}
	
	public void moveDiagoHG() {
		this.setX(this.getX() - 1);
		this.setY(this.getY() - 1);
	}
	
	public void moveDiagoBD() {
		this.setX(this.getX() + 1);
		this.setY(this.getY() + 1);
	}
	
	public void moveDiagoBG() {
		this.setX(this.getX() - 1);
		this.setY(this.getY() + 1);
	}
	
	public String getFireDirection()
	{
		return this.fireDirection;
	}
	
	public char[][] move(char[][] map, String fireDirection)
	{
		if(fireDirection == "LEFT")
		{
			map[this.y][this.x] = ' ';
			this.moveLeft();
			map[this.y][this.x] = 'F';
			this.fireDirection = "LEFT";
		}	
			
		else if(fireDirection == "UP")
		{
			map[this.y][this.x] = ' ';
			this.moveUp();
			map[this.y][this.x] = 'F';
			this.fireDirection = "UP";
		}	
			
		else if(fireDirection == "RIGHT")
		{
			map[this.y][this.x] = ' ';
			this.moveRight();
			map[this.y][this.x] = 'F';
			this.fireDirection = "RIGHT";
		}	
			
		else if(fireDirection == "DOWN")
		{
			map[this.y][this.x] = ' ';
			this.moveDown();
			map[this.y][this.x] = 'F';
			this.fireDirection = "DOWN";
		}
		
		else if(fireDirection == "DIAGOHD")
		{
			map[this.y][this.x] = ' ';
			this.moveDiagoHD();
			map[this.y][this.x] = 'F';
			this.fireDirection = "DIAGOHD";
		}
		
		else if(fireDirection == "DIAGOHG")
		{
			map[this.y][this.x] = ' ';
			this.moveDiagoHG();
			map[this.y][this.x] = 'F';
			this.fireDirection = "DIAGOHG";
		}
		
		else if(fireDirection == "DIAGOBG")
		{
			map[this.y][this.x] = ' ';
			this.moveDiagoBG();
			map[this.y][this.x] = 'F';
			this.fireDirection = "DIAGOBG";
		}
		
		else if(fireDirection == "DIAGOBD")
		{
			map[this.y][this.x] = ' ';
			this.moveDiagoBD();
			map[this.y][this.x] = 'F';
			this.fireDirection = "DIAGOBD";
		}
		
		return map;
	}
	
	public char[][] move(char[][] map, String fireDirection, int y, int x)
	{		
		map[this.y][this.x] = ' ';
		this.setX(x);
		this.setY(y);
		map[this.y][this.x] = 'F';
		this.fireDirection = fireDirection;
			
		return map;
	}
	
}
