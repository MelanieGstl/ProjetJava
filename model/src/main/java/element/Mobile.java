package element;

import java.awt.Point;
/**
 * The Class Mobile.
 * 
 * @author Groupe 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 *
 */
public class Mobile {
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/** The vertical place of an element */
	private int y;


/////////////////////////////////////////////////////////GETTERS//////////////////////////////////////////////////////////////
	/**
	 * Get the vertical place of an element
	 * 
	 * @return y
	 * 			the vertical place of an element
	 */
	public int getY()
	{
		return this.y;
	}


/////////////////////////////////////////////////////////SETTERS//////////////////////////////////////////////////////////////

	/**
	 * Set the vertical place of an element
	 * 
	 * @param y
	 * 			the vertical place of an element
	 */
	public void setY(int y)
	{
		this.y = y;
	}


////////////////////////////////////////////////////////METHODS///////////////////////////////////////////////////////////////
	/**
	 * Move up an element 
	 * 
	 * @param y
	 * 			the vertical place of an element
	 */
	public void moveUp(int y)
	{
		this.setY(this.getY() - 1);
	}
	
}
