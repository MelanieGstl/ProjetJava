
package element;

import java.awt.Point;

import model.Model;

/**
 * The Class Shoot.
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 *
 */
public class Shoot{
	
///////////////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////////////
	/**
	 * Instanciate a new shoot
	 * 
	 * @param x
	 * 			the horizontal place of the shoot
	 * @param y
	 * 			the vertical place of the shoot
	 */
	public Shoot(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/** The horizontal place of the shoot */
	private int x;
	
	/** The vertical place of the shoot */
	private int y;
	
	/**	The direction of the shoot near the hero */
	private String fireDirection = "RIGHT";	


/////////////////////////////////////////////////////////GETTERS//////////////////////////////////////////////////////////////

	/**
	 * Gets the horizontal place of the shoot
	 * 
	 * @return x
	 * 			the horizontal place of the shoot
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * Gets the vertical place of the shoot
	 * 
	 * @return y
	 * 			the vertical place of the shoot
	 */
	public int getY()
	{
		return this.y;
	}
	
	/**
	 * Gets fire direction
	 * 
	 * @return fireDirection
	 * 			The direction of the shoot near the hero
	 */
	public String getFireDirection()
	{
		return this.fireDirection;
	}

/////////////////////////////////////////////////////////SETTERS//////////////////////////////////////////////////////////////

	/**
	 * Set the horizontal place of the shoot
	 * 
	 * @param x
	 * 			the horizontal place of the shoot
	 */
	public void setX(int x)
	{
		this.x = x;
	}

	/**
	 * Set the vertical place of the shoot
	 * 
	 * @param y
	 * 			the vertical place of the shoot
	 */
	public void setY(int y)
	{
		this.y = y;
	}


////////////////////////////////////////////////////////METHODS///////////////////////////////////////////////////////////////

	/**
	 * Place the shoot above the hero
	 */
	public void moveUp() {
		this.setY(this.getY() - 1);	
	}

	/**
	 * Place the shoot to the left of hero
	 */
	public void moveLeft() {
		this.setX(this.getX() - 1);
	}

	/**
	 * Place the shoot under the hero
	 */
	public void moveDown() {
		this.setY(this.getY() + 1);
	}

	/**
	 * Place the shoot to the right of hero
	 */
	public void moveRight() {
		this.setX(this.getX() + 1);
	}
	
	/**
	 * Place the shoot in the top right-hand corner near the hero
	 */
	public void moveDiagoHD() {
		this.setX(this.getX() + 1);
		this.setY(this.getY() - 1);
	}
	
	/**
	 * Place the shoot in the top left-hand corner near the hero
	 */
	public void moveDiagoHG() {
		this.setX(this.getX() - 1);
		this.setY(this.getY() - 1);
	}
	
	/**
	 * Place the shoot in the bottom right-hand corner near the hero
	 */
	public void moveDiagoBD() {
		this.setX(this.getX() + 1);
		this.setY(this.getY() + 1);
	}
	
	/**
	 * Place the shoot in the bottom left-hand corner near the hero
	 */
	public void moveDiagoBG() {
		this.setX(this.getX() - 1);
		this.setY(this.getY() + 1);
	}
	
	/**
	 * Move a shoot on the array depending his position and the direction of the fire
	 * 
	 * @param map
	 * 			the array with the map
	 * 
	 * @param fireDirection
	 * 			The direction of the shoot near the hero
	 * 
	 * @return map
	 * 			the array with the map
	 */
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
	
	/**
	 * Move a shoot on the array depending his position and the direction of the fire
	 * 
	 * @param map
	 * 			the array with the map
	 * 
	 * @param fireDirection
	 * 			The direction of the shoot near the hero
	 * 
	 * @param x
	 * 			the horizontal place of the shoot
	 * 
	 * @param y
	 * 			the vertical place of the shoot
	 * 
	 * @return map
	 * 			the array with the map
	 */
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
