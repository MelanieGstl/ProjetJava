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
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 */
public class ViewPanel extends JPanel implements Observer {

///////////////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////////////

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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/** The view frame. */
	private ViewFrame viewFrame;
	
	/** Attribute to know if the game is finished */
	private int gameOver = 0;
	
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID = -998294702363713521L;
	
	/** Table with the map which is read */
	private char[][] map;
	
	/** Attribute used to calculate the moment when we have to write the score on in the window */
	private int h = 0;

	
/////////////////////////////////////////////////////////GETTERS//////////////////////////////////////////////////////////////
	
	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}
	
	
/////////////////////////////////////////////////////////SETTERS//////////////////////////////////////////////////////////////

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}


////////////////////////////////////////////////////////METHODS///////////////////////////////////////////////////////////////
	
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
					
					case '1':
						try {
							Image img = ImageIO.read(new File("C:/Users/Hugoo/git/ProjetJava/sprite/monster_1.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case '2':
						try {
							Image img = ImageIO.read(new File("C:/Users/Hugoo/git/ProjetJava/sprite/monster_2.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case '3':
						try {
							Image img = ImageIO.read(new File("C:/Users/Hugoo/git/ProjetJava/sprite/monster_3.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case '4':
						try {
							Image img = ImageIO.read(new File("C:/Users/Hugoo/git/ProjetJava/sprite/monster_4.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'C':
						try {
							Image img = ImageIO.read(new File("C:/Users/Hugoo/git/ProjetJava/sprite/gate_open.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
					break;
					
					case 'l':					
						graphics.drawImage((new ImageIcon("C:/Users/Hugoo/git/ProjetJava/sprite/lorann.gif")).getImage(),32*j,32*i, this);
					break;
					
					case 'F':						
						graphics.drawImage((new ImageIcon("C:/Users/Hugoo/git/ProjetJava/sprite/Boule_feu.gif")).getImage(), 32*j, 32*i, this);						
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
		
		if(this.viewFrame.getModel().checkPosition())
		{
			if(this.gameOver == 0)
			{
				this.gameOver = 1;	
				this.viewFrame.printMap("GAME OVER !");
				this.viewFrame.FenetreScore();
				this.viewFrame.getModel().InsertScore(this.viewFrame.getName(), this.viewFrame.getModel().getScore());
			}
		}
		
		this.viewFrame.getModel().animateFire();			
				
		this.viewFrame.getModel().checkPosition();

		if(this.viewFrame.getModel().checkPosition() == false)
		{
			for(int i = 0; i < 1000000000; i++)
			{
				if(i == 50)
				{
					this.viewFrame.getModel().moveMonster();
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
				this.viewFrame.getModel().InsertScore(this.viewFrame.getName(), this.viewFrame.getModel().getScore());
			}
		}
		
		
		
		//Write the best score at the beginning of the game only when we start the game
		if (this.h < 1) {		
			this.viewFrame.getModel().loadHighscore();
			for(int c = 1;c < 8; c++){
				if(c==1) {
					graphics.setColor(Color.PINK);
					graphics.drawString("This are the best score for this game, applause us !!",256,64*c);
					graphics.setColor(Color.YELLOW);
					graphics.drawString("Highscores :",256,64+32*c);
				}
				else {
					graphics.setColor(Color.CYAN);
					for (int i = 0 ; i < 6;) {
						graphics.drawString(this.viewFrame.getModel().getPlayerName(i) + " :  " + this.viewFrame.getModel().getPlayerScore(i), 256, (128+ (32 * i)));
						i++;
					}
				}
			}

		}
		this.h++;
		
		//Print the score and the level in the bottom of the window 
		if(h>2) {
			graphics.setColor(Color.MAGENTA);
			graphics.drawString("--> Score : "+ this.viewFrame.getModel().getScore(), 4, this.getHeight()-10);
			graphics.setColor(Color.PINK);
			graphics.drawString("--> Level : " + this.viewFrame.getModel().getLevel(), 200, this.getHeight()-10);
			graphics.setColor(Color.BLACK);
		}	
		
	}
	


}
