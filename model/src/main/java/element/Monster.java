
package element;

import java.awt.Point;
import model.Model;

/**
 * The Class Monster.
 *
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 */
public class Monster{
	
///////////////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////////////
	/**
	 * Instanciate a new monster
	 * 
	 * @param x
	 * 			the horizontal place of a monster
	 * @param y
	 * 			the vertical place of a monster
	 */
	public Monster(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/** The horizontal place of a monster */
	private int x;
	
	/** The vertical place of a monster */
	private int y;
	
	/** Indicator if the monster is dead */
	private int death = 1;


/////////////////////////////////////////////////////////GETTERS//////////////////////////////////////////////////////////////

	/**
	 * Gets the horizontal place of a monster
	 * 
	 * @return x
	 * 			the horizontal place of a monster
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * Gets the vertical place of a monster
	 * 
	 * @return y
	 * 			the vertical place of a monster
	 */
	public int getY()
	{
		return this.y;
	}
	
	/**
	 * Gets if a monster is dead
	 * 
	 * @return death Indicator if the monster is dead
	 */
	public int getDeath()
	{
		return this.death;
	}


/////////////////////////////////////////////////////////SETTERS//////////////////////////////////////////////////////////////
	
	/**
	 * Set the horizontal place of a monster
	 * 
	 * @param x
	 * 		the horizontal place of a monster
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 * Set the vertical place of a monster
	 * 
	 * @param y
	 * 		the vertical place of a monster
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	/**
	 * Set if a monster is dead
	 * 
	 * @param death Indicator if the monster is dead
	 */
	public void setDeath(int death)
	{
		this.death = death;
	}


////////////////////////////////////////////////////////METHODS///////////////////////////////////////////////////////////////
	
	/**
	 * Change the position of a monster to up
	 */
	public void moveUp() {
		this.setY(this.getY() - 1);	
	}

	/**
	 * Change the position of a monster to left
	 */
	public void moveLeft() {
		this.setX(this.getX() - 1);
	}

	/**
	 * Change the position of a monster to down
	 */
	public void moveDown() {
		this.setY(this.getY() + 1);
	}

	/**
	 * Change the position of a monster to right
	 */
	public void moveRight() {
		this.setX(this.getX() + 1);
	}
	
	/**
	 * Move a monster on the array depending his position and the methods used
	 * 
	 * @param map
	 * 			the array with the map
	 * 
	 * @param move
	 * 			the movement the hero would like to use
	 * 
	 * @param m
	 * 		to choose the correct method
	 * 
	 * @return map
	 * 			the array with the map
	 */
	public char[][] move(char[][] map, String move, int m)
	{
		char n = ' ';
		
		switch(m)
		{
			case 1:
				n = '1';
			break;
			
			case 2:
				n = '2';
			break;
			
			case 3:
				n = '3';
			break;
			
			case 4:
				n = '4';
			break;
		}
		
		if(this.death == 0)
		{
			if(move == "LEFT")
			{
				map[this.y][this.x] = ' ';
				this.moveLeft();
				map[this.y][this.x] = n;
			}	
			
			else if(move == "UP")
			{
				map[this.y][this.x] = ' ';
				this.moveUp();
				map[this.y][this.x] = n;
			}	
			
			else if(move == "RIGHT")
			{
				map[this.y][this.x] = ' ';
				this.moveRight();
				map[this.y][this.x] = n;
			}	
			
			else if(move == "DOWN")
			{
				map[this.y][this.x] = ' ';
				this.moveDown();
				map[this.y][this.x] = n;
			}	
		}
		return map;
	}
}
