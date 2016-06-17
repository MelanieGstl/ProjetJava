package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 * @param <Hero>
 */
public interface IModel<Hero> {

/////////////////////////////////////////////////////////GETTERS//////////////////////////////////////////////////////////////

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	String getMessage();
	
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
	 * Gets an element.
	 *
	 * @param x, y 
	 */
	char getElement(int x, int y);

	/** 
	 * Gets the hero.
	 *
	 * @return hero
	 */
	Hero getHero();
	
	/** 
	 * Gets the score.
	 *
	 *@return score
	 *			the score
	 */
	int getScore();
	
	/** 
	 * Gets if the map is loaded.
	 *
	 *@return getElementLevel().getLoadMap()
	 *			
	 */
	int getLoadMap();
	
	/**  
	 * Gets the score of the player
	 * 
	 * @param i
	 * 			
	 * @return DBplayerScore
	 * 				the score
	 * 
	 */
	int getDBplayerScore(int i);

	/**  
	 * Gets the level of the player on the game
	 * 
	 * @return level
	 * 				the level
	 */
	int getLevel();

	/**  
	 * Gets the name of the player
	 * 
	 * @param i
	 * 
	 * @return DBplayerName
	 * 				the name of the player
	 */
	String getDBplayerName(int i);
	
/////////////////////////////////////////////////////////SETTERS//////////////////////////////////////////////////////////////
	
	/** 
	 * Set the level
	 * 
	 * @param level
	 * 			the level 
	 */
	void setLevel(int level);


////////////////////////////////////////////////////////METHODS///////////////////////////////////////////////////////////////

	/**
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	void loadMessage(String key);

	/** 
	 * Load the map.
	 * 
	 */
	void loadMap();

	/** 
	 * Load the map from the DataBase.
	 * 
	 * @param key
	 * 		the key
	 */
	void loadMap2(String key);
	
	/**  */
	void setMobileHasChanged();

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

	/** 
	 * Set the last movement (to know where place the fire ball)
	 *  
	 */
	void setLastMove(String string);

	/** 
	 * Place the fire ball 
	 * 
	 */
	void shoot();
	
	/** 
	 * Animate the fire ball
	 * 
	 */
	void animateFire();

	/** 
	 *  Check if the hero in on an element
	 * 
	 */
	boolean checkPosition();

	/** 
	 * Insert a score.
	 *
	 *@param name, score
	 *
	 */
	void InsertScore(String name, int score);

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

	/**  
	 * Load the best scores 
	 * 
	 */
	void loadHighscore();

}
