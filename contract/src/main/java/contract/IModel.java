package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
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

	char[][] getMap();

	int getHeight();

	int getWidth();

	void loadMap();

	void loadMap2(String key);

	char getElement(int x, int y);
	
	void setMobileHasChanged();

	Hero getHero();

	void moveUp();

	void moveLeft();
	
	void moveRight();
	
	void moveDown();

	void moveMonster();

	void setLastMove(String string);

	void shoot();
	
	void animateFire();

	boolean checkPosition();

	void InsertScore(String name, int score);

	int getScore();

	void moveDiagoHD();
	
	void moveDiagoHG();
	
	void moveDiagoBD();
	
	void moveDiagoBG();
}
