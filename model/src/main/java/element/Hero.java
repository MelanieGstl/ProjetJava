
package element;

import java.awt.Point;

import model.Model;

public class Hero{
	
	private int x;
	private int y;
	
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
	
	public char[][] move(char[][] map, String move)
	{
		if(move == "LEFT")
		{
			map[this.y][this.x] = ' ';
			this.moveLeft();
			map[this.y][this.x] = 'l';
		}	
			
		else if(move == "UP")
		{
			map[this.y][this.x] = ' ';
			this.moveUp();
			map[this.y][this.x] = 'l';
		}	
			
		else if(move == "RIGHT")
		{
			map[this.y][this.x] = ' ';
			this.moveRight();
			map[this.y][this.x] = 'l';
		}	
			
		else if(move == "DOWN")
		{
			map[this.y][this.x] = ' ';
			this.moveDown();
			map[this.y][this.x] = 'l';
		}	
		
		return map;
	}
	
}
