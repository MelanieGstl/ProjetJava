
package element;

import java.awt.Point;

import model.Model;

/**
 * The Class Hero.
 *
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 */

public class Hero{
	
///////////////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////////////
	/**
	* Instantiates a new hero.
	* @param x
	 * 			the horizontal place of an hero
	 * @param y
	 * 			the vertical place of an hero
	*/
	public Hero(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/** The horizontal place of an hero */
	private int x;
	
	/** The vertical place of an hero */
	private int y;
	
	
/////////////////////////////////////////////////////////GETTERS//////////////////////////////////////////////////////////////
	
	/** 
     * Gets place of the hero in the horizontal on the map
     *   
     *   @return x
     *   		The horizontal place of an hero
     */
	public int getX()
	{
		return this.x;
	}
	
	/** 
     * Gets place of the hero in the vertical on the map
     *   
     *   @return y
     *   		TThe vertical place of an hero
     */
	public int getY()
	{
		return this.y;
	}
	
/////////////////////////////////////////////////////////SETTERS//////////////////////////////////////////////////////////////

	/** 
     * Gets place of the hero in the horizontal on the map
     *   
     *   @param x
     *   		The horizontal place of an hero
     */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/** 
     * Gets place of the hero in the vertical on the map
     *   
     *   @param y
     *   		The vertical place of an hero
     */
	public void setY(int y)
	{
		this.y = y;
	}
	
////////////////////////////////////////////////////////METHODS///////////////////////////////////////////////////////////////
	
	/**
	 * Change the position of the hero to up
	 */
	public void moveUp() {
		this.setY(this.getY() - 1);	
	}

	/**
	 * Change the position of the hero to left
	 */
	public void moveLeft() {
		this.setX(this.getX() - 1);
	}

	/**
	 * Change the position of the hero to down
	 */
	public void moveDown() {
		this.setY(this.getY() + 1);
	}

	/**
	 * Change the position of the hero to right
	 */
	public void moveRight() {
		this.setX(this.getX() + 1);
	}
	
	/**
	 * Move the hero on the array depending his position and the methods used
	 * 
	 * @param map
	 * 			the array with the map
	 * 
	 * @param move
	 * 			the movement the hero would like to use
	 * 
	 * @return map
	 * 			the array with the map
	 */
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
