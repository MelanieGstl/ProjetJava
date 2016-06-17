package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import com.sun.javafx.scene.traversal.Direction;
import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;	
	
	
//////////////////////////////////////////////////////////SETTERS//////////////////////////////////////////////////////////////
	
	/**
	 * Sets the controller.
	 *
	 *<p>
	 *This method set a new controller
	 *<p>
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
	
	
///////////////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////////////
	
	
	/**
	 * Instantiates a new view.
	 * 
	 *<p>
	 * In this View we can instantiate a ViewFrame and a ViewPanel to post the game and play it.
	 * <p>
	 * 
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}
	
	
////////////////////////////////////////////////METHODS//////////////////////////////////////////////////////////////////////////

	/**
	 * Key code to controller order.
	 * 
	 *<p>
	 * This method take the key which is enter by the player and send the correct values to the controller.
	 * This method use an enumeration and send the values corresponding to the touch to the controller.
	 * <p>
	 * 
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_1:
				return ControllerOrder.ONE;
			case KeyEvent.VK_2:
				return ControllerOrder.TWO;
			case KeyEvent.VK_3:
				return ControllerOrder.THREE;
			case KeyEvent.VK_4:
				return ControllerOrder.FOUR;
			case KeyEvent.VK_5:
				return ControllerOrder.FIVE;
			case KeyEvent.VK_NUMPAD8:
			case KeyEvent.VK_UP:
				return ControllerOrder.UP;
			case KeyEvent.VK_NUMPAD4:
			case KeyEvent.VK_LEFT:
				return ControllerOrder.LEFT;
			case KeyEvent.VK_NUMPAD2:
			case KeyEvent.VK_DOWN:
				return ControllerOrder.DOWN;
			case KeyEvent.VK_NUMPAD6:
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.RIGHT;
			case KeyEvent.VK_SPACE:
				return ControllerOrder.SHOOT;
			case KeyEvent.VK_NUMPAD1:
				return ControllerOrder.DIAGO_BG;
			case KeyEvent.VK_NUMPAD3:
				return ControllerOrder.DIAGO_BD;
			case KeyEvent.VK_NUMPAD7:
				return ControllerOrder.DIAGO_HG;
			case KeyEvent.VK_NUMPAD9:
				return ControllerOrder.DIAGO_HD;
			default:
				return ControllerOrder.NOTHING;
		}
	}

	/**
	 * Prints the map in the window.
	 * 
	 *  @param map
	 *  		the map
	 */
	public void printMap(final String map) {
		this.viewFrame.printMap(map);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

}
