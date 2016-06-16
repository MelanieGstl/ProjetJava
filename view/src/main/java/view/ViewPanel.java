package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	
	private int gameOver = 0;
	
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	
	private char[][] map;

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
		this.viewFrame.getModel().loadMap();		
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
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		this.map = this.viewFrame.getModel().getMap();

		for(int i = 0; i < this.map.length; i++)
		{
			for (int j = 0; j < this.map[i].length; j++)
			{
				switch (this.map[i][j]){
					case 'b':						
						try {
							Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'h':						
						try {
							Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/horizontal_bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'v':						
						try {
							Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/vertical_bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'p':					
						try {
							Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/purse.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'c':					
						try {
							Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/gate_closed.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'e':					
						try {
							Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/crystal_ball.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case '1':
						try {
							Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/monster_1.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case '2':
						try {
							Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/monster_2.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case '3':
						try {
							Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/monster_3.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case '4':
						try {
							Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/monster_4.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'C':
						try {
							Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/gate_open.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'l':					
						graphics.drawImage((new ImageIcon("C:/Users/gstal/git/ProjetJava/sprite/lorann.gif")).getImage(),32*j,32*i, this);
					break;
					
					case 'F':						
						graphics.drawImage((new ImageIcon("C:/Users/gstal/git/ProjetJava/sprite/Boule_feu.gif")).getImage(), 32*j, 32*i, this);						
					break;

					default:
						try {
							Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/noimage.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
						break;
				}
			}
		}
		
		if(this.viewFrame.getModel().checkPosition())
		{
			if(this.gameOver == 0)
			{
				this.gameOver = 1;	
				this.viewFrame.printMap("GAME OVER !");
				this.viewFrame.FenetreScore();
			}
		}
		
		this.viewFrame.getModel().animateFire();			
		
		if(this.viewFrame.getModel().checkPosition())
		{
			if(this.gameOver == 0)
			{
				this.gameOver = 1;
				this.viewFrame.printMap("GAME OVER !");
				//this.viewFrame.FenetreScore();
			}
		}
		
		this.viewFrame.getModel().moveMonster();
	}


}
