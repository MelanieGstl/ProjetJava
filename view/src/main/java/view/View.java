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
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_NUMPAD1:
			case KeyEvent.VK_1:
				return ControllerOrder.ONE;
			case KeyEvent.VK_NUMPAD2:
			case KeyEvent.VK_2:
				return ControllerOrder.TWO;
			case KeyEvent.VK_NUMPAD3:
			case KeyEvent.VK_3:
				return ControllerOrder.THREE;
			case KeyEvent.VK_NUMPAD4:
			case KeyEvent.VK_4:
				return ControllerOrder.FOUR;
			case KeyEvent.VK_NUMPAD5:
			case KeyEvent.VK_5:
				return ControllerOrder.FIVE;
			default:
				return ControllerOrder.ONE;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
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

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
