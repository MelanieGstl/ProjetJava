package model;

import java.awt.Image;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import javax.imageio.ImageIO;

import contract.IModel;
import contract.IView;
import element.*;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel<Hero> {

	/** The message. */
	private String message;
	
	/** The map. */
	private String map;
	
	/** Width */
	private int height = 20;
	
	/** Height */
	private int width = 20;
	
	/** Hero */
	public Hero hero;
	
	private int herox;
	private int heroy;
	
	private int monsterx;
	private int monstery;
	
	private char[][] tableau = new char[this.getWidth()+1][this.getHeight()+1];
	
	private IView view;

	
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.map = "";
		this.hero = new Hero(0, 0);
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
	
    public Hero getHero() {
		return this.hero;
	}
	
	public void loadMap()
	{		
		String[] tabmap = this.map.split("\n"); 
        for (int i = 0; i < tabmap.length; i++)
        {
            for (int j = 0; j < tabmap[i].length(); j++)
            {
                switch (tabmap[i].charAt(j)){
                
                    case 'h':                       
                    	this.tableau[i][j] = 'h'; 
                    	//System.out.print(this.tableau[i][j]);
                   break;
                        
                    case 'b':                                           
                    	this.tableau[i][j] = 'b';    
                    	//System.out.print(this.tableau[i][j]);
                    break;
                        
                    case 'v':                       
                    	this.tableau[i][j] = 'v';  
                    	//System.out.print(this.tableau[i][j]);
                    break;
                    	
                    case 'p':                       
                    	this.tableau[i][j] = 'p'; 
                    	//System.out.print(this.tableau[i][j]);
                    break;
                    
                    case 'e':                       
                    	this.tableau[i][j] = 'e'; 
                    	//System.out.print(this.tableau[i][j]);
                    break;
                    
                    case 'l':                       
                    	this.tableau[i][j] = 'l';
                    	this.hero.setX(j);
                    	this.hero.setY(i);                    	
                    break;
                    
                    default:
                    	this.tableau[i][j] = ' ';   
                    	//System.out.print(this.tableau[i][j]);
                    break;
                }     
            }
        }

        /*for (int i =0; i < tabmap.length; i++)
        {
            for (int j = 0; j < tabmap[i].length(); j++)
            {
            	System.out.print(this.tableau[i][j]);
            }
            
            System.out.println();
        }*/
	}
	
	private boolean isMovePossible(final int x, final int y) {
		if(this.getElement(x, y) == 'h' || this.getElement(x, y) == 'v' || this.getElement(x, y) == 'b'){
			return false;
		}else{
			return true;
		}
	}

	public void moveUp() {
		if(this.isMovePossible(this.getHero().getY()-1, this.getHero().getX()))
		{
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveUp();		
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
		System.out.println("X : "+this.getHero().getX());
		System.out.println("Y : "+this.getHero().getY());
	}
	
	public void moveLeft() {
		if(this.isMovePossible(this.getHero().getY(), this.getHero().getX()-1))
		{
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveLeft();		
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
		System.out.println("X : "+this.getHero().getX());
		System.out.println("Y : "+this.getHero().getY());
	}
	
	public void moveRight() {
		if(this.isMovePossible(this.getHero().getY(), this.getHero().getX()+1))
		{
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveRight();		
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
		System.out.println("X : "+this.getHero().getX());
		System.out.println("Y : "+this.getHero().getY());
		System.out.println("X + 1 : "+this.tableau[this.getHero().getY()][this.getHero().getX()+1]);
	}
	
	public void moveDown() {
		if(this.isMovePossible(this.getHero().getY()+1, this.getHero().getX()))
		{
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveDown();		
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
		System.out.println("X : "+this.getHero().getX());
		System.out.println("Y : "+this.getHero().getY());
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public int getMonsterX()
	{
		return this.monsterx;
	}
	
	public int getMonsterY()
	{
		return this.monstery;
	}
	
	public void setMonsterX(int x)
	{
		this.monsterx = x;
	}
	
	public void setMonsterY(int y)
	{
		this.monstery = y;
	}
	
	public char[][] getMap() {
        return this.tableau;
    }
	
	public char getElement(int x, int y){
		if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())) {
			return (Character) null;
		}
		return this.tableau[x][y];
	}

    private void setMap(final String map) {
        this.map = map;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void setMobileHasChanged(){
    	this.setChanged();
    	this.notifyObservers();
    }
    
    public void loadMap2(String key) {
        try {
            final DAOLoadMap daoLoadMap = new DAOLoadMap(DBConnection.getInstance().getConnection());
            this.setMap(daoLoadMap.find(key).getMap());
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

}
