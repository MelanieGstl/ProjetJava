package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	//public char[][] map = new char[12][21];

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		//this.map = this.viewFrame.getModel().getMap();
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		//graphics.drawString(this.getViewFrame().getModel().getMap(), 10, 20);

		/**for(int i=0; i<this.viewFrame.getModel().getMap().length; i++)
		{
			for (int j = 0; j < this.viewFrame.getModel().getMap()[i].length; j++)
			{
				this.map[i][j] = this.viewFrame.getModel().getMap()[i][j];
			}
		}**/
		this.viewFrame.getModel().loadMap();


		char[][] map = this.viewFrame.getModel().getMap();
		/**for (int i = 0; i < 21; i++) {
			System.arraycopy(this.viewFrame.getModel().getMap()[i], 0, map[i], 0, this.viewFrame.getModel().getMap()[i].length);
		}**/

		for(int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[i].length; j++)
			{
				switch (map[i][j]){
					case 'b':						
						try {
							Image img = ImageIO.read(new File("C:/Users/Hugoo/git/ProjetJava/sprite/bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'h':						
						try {
							Image img = ImageIO.read(new File("C:/Users/Hugoo/git/ProjetJava/sprite/horizontal_bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'v':						
						try {
							Image img = ImageIO.read(new File("C:/Users/Hugoo/git/ProjetJava/sprite/vertical_bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'p':					
						try {
							Image img = ImageIO.read(new File("C:/Users/Hugoo/git/ProjetJava/sprite/purse.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'c':					
						try {
							Image img = ImageIO.read(new File("C:/Users/Hugoo/git/ProjetJava/sprite/gate_closed.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'e':					
						try {
							Image img = ImageIO.read(new File("C:/Users/Hugoo/git/ProjetJava/sprite/crystal_ball.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'l':					
						try {
							Image img = ImageIO.read(new File("C:/Users/Hugoo/git/ProjetJava/sprite/lorann.gif"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
				
					default:
						try {
							Image img = ImageIO.read(new File("C:/Users/Hugoo/git/ProjetJava/sprite/noimage.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
						break;
				}
			}
		}
	}


}
