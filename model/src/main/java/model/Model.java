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
	public Monster monster;
	public Monster monster2;
	public Monster monster3;
	public Monster monster4;
	 
	
	private char[][] tableau = new char[this.getWidth()+1][this.getHeight()+1];
	
	private IView view;

	
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.map = "";
		this.hero = new Hero(0, 0);
		this.monster = new Monster(0, 0);
		this.monster2 = new Monster(0, 0);
		this.monster3 = new Monster(0, 0);
		this.monster4 = new Monster(0, 0);
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
    
    public Monster getMonster(Monster monster) {
		return monster;
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
                    
                    case 'c':                       
                    	this.tableau[i][j] = 'c'; 
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
                    
                    case '1':
                    	this.tableau[i][j] = '1';
                    	this.monster.setX(j);
                    	this.monster.setY(i);
                    break;
                    
                    case '2':
                    	this.tableau[i][j] = '2';
                    	this.monster2.setX(j);
                    	this.monster2.setY(i);
                    break;
                    
                    case '3':
                    	this.tableau[i][j] = '3';
                    	this.monster3.setX(j);
                    	this.monster3.setY(i);
                    break;
                    
                    case '4':
                    	this.tableau[i][j] = '4';
                    	this.monster4.setX(j);
                    	this.monster4.setY(i);
                    break;
                    
                    default:
                    	this.tableau[i][j] = ' ';   
                    	//System.out.print(this.tableau[i][j]);
                    break;
                }     
            }
        }
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
	}
	
	public void moveLeft() {
		if(this.isMovePossible(this.getHero().getY(), this.getHero().getX()-1))
		{
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveLeft();		
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
	}
	
	public void moveRight() {
		if(this.isMovePossible(this.getHero().getY(), this.getHero().getX()+1))
		{
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveRight();		
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
	}
	
	public void moveDown() {
		if(this.isMovePossible(this.getHero().getY()+1, this.getHero().getX()))
		{
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveDown();		
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
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

	public void moveMonster() {
		if(this.getMonster(this.monster).getX() > this.getHero().getX())
		{
			if(this.isMovePossible(this.getMonster(this.monster).getY(), this.getMonster(this.monster).getX()-1))
			{
				this.tableau[this.getMonster(this.monster).getY()][this.getMonster(this.monster).getX()] = ' ';
				this.getMonster(this.monster).moveLeft();		
				this.tableau[this.getMonster(this.monster).getY()][this.getMonster(this.monster).getX()] = '1';
			}
		}
		
		else if(this.getMonster(this.monster).getX() < this.getHero().getX())
		{
			if(this.isMovePossible(this.getMonster(this.monster).getY(), this.getMonster(this.monster).getX()+1))
			{
				this.tableau[this.getMonster(this.monster).getY()][this.getMonster(this.monster).getX()] = ' ';
				this.getMonster(this.monster).moveRight();		
				this.tableau[this.getMonster(this.monster).getY()][this.getMonster(this.monster).getX()] = '1';
			}
		}
		
		else if(this.getMonster(this.monster).getY() < this.getHero().getY())
		{
			if(this.isMovePossible(this.getMonster(this.monster).getY()+1, this.getMonster(this.monster).getX()))
			{
				this.tableau[this.getMonster(this.monster).getY()][this.getMonster(this.monster).getX()] = ' ';
				this.getMonster(this.monster).moveDown();		
				this.tableau[this.getMonster(this.monster).getY()][this.getMonster(this.monster).getX()] = '1';
			}
		}
		
		else if(this.getMonster(this.monster).getY() > this.getHero().getY())
		{
			if(this.isMovePossible(this.getMonster(this.monster).getY()-1, this.getMonster(this.monster).getX()))
			{
				this.tableau[this.getMonster(this.monster).getY()][this.getMonster(this.monster).getX()] = ' ';
				this.getMonster(this.monster).moveUp();		
				this.tableau[this.getMonster(this.monster).getY()][this.getMonster(this.monster).getX()] = '1';
			}
		}
	}
    
    

}
