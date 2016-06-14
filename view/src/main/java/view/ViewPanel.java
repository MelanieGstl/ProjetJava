package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
///////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/*private BufferedImage image;
	private BufferedImage img;
	
	public ViewPanel () {
		try {
			//image = ImageIO.read(getClass().getResourceAsStream("/bone.png"));
			this.img = ImageIO.read(new File("bone.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		repaint();
	}*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////
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
		graphics.drawString(this.getViewFrame().getModel().getMessage(), 10, 20);
		//graphics.drawImage(this.img, 10, 10, null);
		try {
		      Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/horizontal_bone.png"));
		      Image img2 = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/bone.png"));
		      graphics.drawImage(img, 0, 0, this);
		      graphics.drawImage(img2, 32, 0, this);

		    } catch (IOException e) {

		      e.printStackTrace();

		    } 
		
			
			char[][] map = new char[30][30];
				map = this.viewFrame.getModel().getMap();
			
		for(int y = 0; y < this.getHeight()+1; y++){
			for(int x = 0; x < this.getWidth()+1; x++){
				
				//Arrays.deepToString(a)
						/*switch(map[x][y])
						{
						
							case 'h':
								try {
								      Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/horizontal_bone.png"));
								      graphics.drawImage(img, 0, 0, this);

								    } catch (IOException e) {

								      e.printStackTrace();

								    } 
											
							break;
							
							case 'b':
								try {
								      Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/bone.png"));
								      graphics.drawImage(img, 0, 0, this);

								    } catch (IOException e) {

								      e.printStackTrace();

								    } 
								
							break;
							
							case 'v':
								try {
								      Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/vertical_bone.png"));
								      graphics.drawImage(img, 0, 0, this);

								    } catch (IOException e) {

								      e.printStackTrace();

								    } 
							
								
							break;
							
							case 'p':
								try {
								      Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/purse.png"));
								      graphics.drawImage(img, 0, 0, this);

								    } catch (IOException e) {

								      e.printStackTrace();

								    } 
							
								
							break;
							
							case 'e':
								try {
								      Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/crystal_bone.png"));
								      graphics.drawImage(img, 0, 0, this);

								    } catch (IOException e) {

								      e.printStackTrace();

								    } 
							
								
							break;
							
							case 'c':	
								try {
								      Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/gate_closed.png"));
								      graphics.drawImage(img, 0, 0, this);

								    } catch (IOException e) {

								      e.printStackTrace();

								    } 
							
						
							break;
							
								}*/
						}
			}
		}
						
			
		/*try {
		      Image img = ImageIO.read(new File("C:/Users/gstal/git/ProjetJava/sprite/bone.png"));
		      graphics.drawImage(img, 0, 0, this);

		    } catch (IOException e) {

		      e.printStackTrace();

		    } */


}

