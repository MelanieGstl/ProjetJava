package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 * @param <Hero>
 */
public interface IModel<Hero> {

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	String getMessage();

	/**
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	void loadMessage(String key);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	/** 
	 * Gets the map.
	 *
	 * @return the map 
	 */
	char[][] getMap();

	/** 
	 * Gets the height.
	 *
	 * @return the height 
	 */
	int getHeight();

	/** 
	 * Gets the width.
	 *
	 * @return the width 
	 */
	int getWidth();

	/** 
	 * Load the map.
	 * 
	 */
	void loadMap();

	/** 
	 * Load the map.
	 * 
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	/** 
	 * Load the map.
	 * 
	 * @param key
	 * 		the key
	 */
	void loadMap2(String key);

	/** 
	 * Gets an element.
	 *
	 * @param x, y 
	 */
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	char getElement(int x, int y);
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	void setMobileHasChanged();

	/** 
	 * Gets the hero.
	 *
	 * @return hero
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	Hero getHero();

	/** 
	 * Move Hero.
	 *
	 */
	void moveHero(String move);

	/** 
	 * Move the monster.
	 *
	 */
	void moveMonster();

	void setLastMove(String string);

	void shoot();
	
	void animateFire();

	boolean checkPosition();

	/** 
	 * Insert a score.
	 *
	 *@param name, score
	 */
	void InsertScore(String name, int score);

	/** 
	 * Get the score.
	 *
	 *@return score
	 *			the score
	 */
	int getScore();

	/** 
	 * Move diagonal Up Right.
	 *
	 */
	void moveDiagoHD();
	
	/** 
	 * Move diagonal Up Left.
	 *
	 */
	void moveDiagoHG();
	
	/** 
	 * Move diagonal Down Right.
	 *
	 */
	void moveDiagoBD();
	
	/** 
	 * Move diagonal Down Left.
	 *
	 */
	void moveDiagoBG();

	int getLoadMap();
}
