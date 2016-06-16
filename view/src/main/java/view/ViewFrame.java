package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;

/**
 * The Class ViewFrame.
 *
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 */
class ViewFrame extends JFrame implements KeyListener {

	/** The model. */
	private IModel						model;

	/** The controller. */
	private IController				controller;
	
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;

	/**
	 * Instantiates a new view frame.
	 *<p>
	 * In this frame we can post a panel to see the graphic game.
	 * <p>
	 * 
	 * @param model
	 *          the model
	 * @throws HeadlessException
	 *           the headless exception : Thrown when code that is dependent on a keyboard, display, or mouse 
	 *           is called in an environment that does not support a keyboard, display, or mouse
	 */
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * <p>
	 * In this frame we can post a panel to see the graphic game.
	 * <p>
	 *
	 * @param model
	 *          the model
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * <p>
	 * In this frame we can post a panel to see the graphic game.
	 * <p>
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * <p>
	 * In this frame we can post a panel to see the graphic game.
	 * <p>
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	/**
	 * Gets the controller.
	 *
	 * <p>
	 * This method return the controller we used.
	 * <p>
	 * @return the controller
	 */
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 *<p>
	 *This method set a new controller
	 *<p>
	 * @param controller
	 *          the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 * 
	 * <p>
	 * This method return the controller we used.
	 * <p>
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 * 
	 *<p>
	 *This method set a new model
	 *<p>
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Builds the view frame.
	 * 
	 * <p>
	 * This method is used to build the frame which will be used to play the game.
	 * We can put the size, the panel and all information about the frame in which we are going to post the game and play it.
	 * <p>
	 *
	 * @param model
	 *          the model
	 */
	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
		this.setSize(650,510);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Prints the map.
	 *<p>
	 *This method is used to print the map.
	 *<p>
	 * @param map
	 *          the message
	 */
	public void printMap(final String map) {
		JOptionPane.showMessageDialog(null, map);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {
		// this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {
		// this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}
}
