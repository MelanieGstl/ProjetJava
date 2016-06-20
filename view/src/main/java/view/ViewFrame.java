package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import contract.IController;
import contract.IModel;

import javax.swing.JTextField;

/**
 * The Class ViewFrame.
 *
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 */
class ViewFrame extends JFrame implements KeyListener {

	/** The model. */
	private IModel model;
	
	/** The controller. */
	private IController controller;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -697358409737458175L;
	
	/** The name of the player*/
  	private String name;
  	
  	/** The score of the player*/ 
  	private int score;

  	
  /////////////////////////////////////////////////////////GETTERS//////////////////////////////////////////////////////////////
  	
  	/**
	 * Gets the controller.
	 *
	 * <p>
	 * This method return the controller we used.
	 * <p>
	 * 
	 * @return the controller
	 */
	private IController getController() {
		return this.controller;
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
	 * Gets the name of the player.
	 * 
	 * <p>
	 * This method name of the player which is enter in the window.
	 * <p>
	 *
	 * @return the name
	 */
  	public String getName(){
  		return this.name;
  	}
	
 //////////////////////////////////////////////////////////SETTERS//////////////////////////////////////////////////////////////
  	
	/**
	 * Sets the controller.
	 *
	 *<p>
	 *This method set a controller
	 *<p>
	 * @param controller
	 *          the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
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
  	
  	
  ///////////////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////////////
	
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
	 *          the graphics configuration
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
	 *          the graphics configuration
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	
////////////////////////////////////////////////METHODS//////////////////////////////////////////////////////////////////////////

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
		this.setSize(650,580);
		this.setLocationRelativeTo(null);
	}
	
	  	
	/**
	* Builds the window for the score.
	*/  	
	public void FenetreScore() {
		/*this.setTitle("Score");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    container.setBackground(Color.white);
	    container.setLayout(new BorderLayout());
	    JPanel top = new JPanel();
	    Font police = new Font("Arial", Font.BOLD, 14);
	    jtf.setFont(police);
	    jtf.setPreferredSize(new Dimension(150, 30));
	    jtf.setForeground(Color.BLUE);
	    top.add(label);
	    top.add(jtf);
	    container.add(top, BorderLayout.NORTH);
	    this.setContentPane(container);
	    this.setVisible(true);*/
		JOptionPane jOptionPane = new JOptionPane(); 
		JOptionPane jOptionPane2 = new JOptionPane();
		this.name = jOptionPane.showInputDialog(null, "Enter your name please", "");
		if(this.name == null)
		{
			this.name = "Unkown";
		}
		jOptionPane.showMessageDialog(null, "You score is saved", null, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Prints the map.
	 *<p>
	 *This method is used to print the map.
	 *<p>
	 * @param map
	 *          the map
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
