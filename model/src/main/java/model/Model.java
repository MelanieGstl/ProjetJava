package model;

import java.awt.Image;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import javax.imageio.ImageIO;

import contract.IModel;
import element.*;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	/** The message. */
	private String message;

	/** Width */
	private int height = 15;
	
	/** Height */
	private int width = 20;
	
	private char[][] tableau = new char[this.getWidth()+1][this.getHeight()+1];
	
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
	}
	
	/*/**
	 * Instantiates a new level with the file given
	 * @param fileName
	 * @throws IOException
	 */
	/*public Model(final String fileName) throws IOException {
		this();
		this.loadFile(fileName);
	*/
	
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	private void setMessage(final String message) {
		this.message = message;
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMessage(final String key) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMessage(daoHelloWorld.find(key).getMessage());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public void loadFile(final String fileName)
	{
		try
		{
		    File f = new File (fileName);
		    FileReader fr = new FileReader (f);
		 
		    int c = fr.read();
		    int x = 0;
		    int y = 0;
		    
			while (c != -1)
			{				
				if(y < this.getHeight()+1)
				{	
					if((char) c != '\r')
					{
						this.tableau[x][y] = (char) c;
						
						switch((char) c)
						{						
							case 'h':
									
							break;
							
							case 'b':							
								
							break;
							
							case 'v':
								
							break;
							
							case 'p':							
								
							break;
							
							case 'e':							
								
							break;
							
							case 'c':							
								
							break;
							
							/*case '':						
								this.addElement(new Forest(), x, y);	
								//System.out.print('F');
							break;*/
							
						}
						
						x++;
						
						if(x == this.getWidth()+1)
						{
							y++;
							x = 0;
						}
					}
				}
				
				c = fr.read();
				
			}
			fr.close();
		
		}
		catch (IOException exception)
		{
		    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
		
		// pour afficher le tableau
		for(int y = 0; y < this.getHeight(); y++){
			for(int x = 0; x < this.getWidth()+1; x++){
				System.out.print(tableau[x][y]);
			}
		}
	}
}
