package model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	/** The message. */
	private String message;

	/** Width */
	private int height;
	
	/** Height */
	private int width;
	
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
	}

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
		    File f = new File ("C:/Users/Hugoo/Desktop/CESI/Prosit 34/NettleWorld/src/jpu2016/nettleWorld.txt");
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
					
						switch((char) c)
						{
						
							/*case 'S':
								this.addElement(new Stone(), x, y);	
								//System.out.print('S');
							break;
							
							case ' ':							
								this.addElement(new Land(), x, y);	
								//System.out.print('_');
							break;
							
							case 'W':
								this.addElement(new Water(), x, y);	
								//System.out.print('W');
							break;
							
							case 'C':							
								this.addElement(new Camp(), x, y);
								//System.out.print('C');
							break;
							
							case 'T':							
								this.addElement(new Town(), x, y);		
								//System.out.print('T');
							break;
							
							case 'M':							
								this.addElement(new Monastery(), x, y);		
								//System.out.print('M');
							break;
							
							case 'F':						
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
	}
}
