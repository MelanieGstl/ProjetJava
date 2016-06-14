package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

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

	Object getHero();

}
