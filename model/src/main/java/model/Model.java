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
	public Shoot shoot;
	public Map MAP;
	
	private char[][] tableau = new char[this.getWidth()+1][this.getHeight()+1];
		
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.map = "";
		this.hero = new Hero(0, 0);
		this.monster = new Monster(0, 1);
		this.monster2 = new Monster(0, 2);
		this.monster3 = new Monster(0, 3);
		this.monster4 = new Monster(0, 4);
		this.shoot = new Shoot(5, 5);
		this.MAP = new Map();
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
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void InsertScore(final String name, final int score) {
		try {
			final DAOScore daoScore = new DAOScore(DBConnection.getInstance().getConnection());
			daoScore.SaveScore(name, score);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	public int getScore()
	{
		return this.getMAP().getScore();
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
    
    public Shoot getShoot()
    {
    	return this.shoot;
    }
    
	public Map getMAP() {
		return this.MAP;
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
                    	this.getMAP().setGateX(j);
                    	this.getMAP().setGateY(i);
                    	//System.out.print(this.tableau[i][j]);
                    break;
                    
                    case 'e':                       
                    	this.tableau[i][j] = 'e'; 
                    	this.getMAP().setEnergyX(j);
                    	this.getMAP().setEnergyY(i);
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
	
	public boolean isMovePossible(final int x, final int y) {
		if(this.getElement(x, y) == 'h' || this.getElement(x, y) == 'v' || this.getElement(x, y) == 'b' || this.getElement(x, y) == 'p' || this.getElement(x, y) == 'e' || this.getElement(x, y) == 'c' || this.getElement(x, y) == 'C'){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean isMovePossible2(final int x, final int y) {
		if(this.getElement(x, y) == 'h' || this.getElement(x, y) == 'v' || this.getElement(x, y) == 'b'){
			return false;
		}else{
			return true;
		}
	}

	public void moveUp() {
		if(this.isMovePossible2(this.getHero().getY()-1, this.getHero().getX()))
		{
			if(this.getElement(this.getHero().getY()-1, this.getHero().getX()) == 'p')
			{
				this.getMAP().setScore(this.getMAP().getScore() + 100);		
			}
			
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveUp();		
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
	}
	
	public void moveLeft() {
		if(this.isMovePossible2(this.getHero().getY(), this.getHero().getX()-1))
		{
			if(this.getElement(this.getHero().getY(), this.getHero().getX()-1) == 'p')
			{
				this.getMAP().setScore(this.getMAP().getScore() + 100);			
			}
			
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveLeft();		
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
	}
	
	public void moveRight() {
		if(this.isMovePossible2(this.getHero().getY(), this.getHero().getX()+1))
		{
			if(this.getElement(this.getHero().getY(), this.getHero().getX()+1) == 'p')
			{
				this.getMAP().setScore(this.getMAP().getScore() + 100);			
			}
			
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveRight();		
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
	}
	
	public void moveDown() {
		if(this.isMovePossible2(this.getHero().getY()+1, this.getHero().getX()))
		{
			if(this.getElement(this.getHero().getY()+1, this.getHero().getX()) == 'p')
			{
				this.getMAP().setScore(this.getMAP().getScore() + 100);			
			}
			
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
    
    public int getLoadMap()
    {
    	return this.getMAP().getLoadMap();
    }
    
    public void loadMap2(String key) {
        try {
            final DAOLoadMap daoLoadMap = new DAOLoadMap(DBConnection.getInstance().getConnection());
            this.setMap(daoLoadMap.find(key).getMap());
            this.getMAP().setLoadMap(1);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

	public void moveMonster() {
		
		System.out.println("Score : "+this.getMAP().getScore());
		
		if(this.getMonster(this.monster).getDeath() == 0)
		{
			if(this.getMonster(this.monster).getX() > this.getHero().getX())
			{
				if(this.isMovePossible(this.getMonster(this.monster).getY(), this.getMonster(this.monster).getX()-1))
				{
					this.tableau = this.getMonster(this.monster).move(this.tableau, "LEFT");
				}
				
				else if(this.isMovePossible(this.getMonster(this.monster).getY()-1, this.getMonster(this.monster).getX()))
				{
					this.tableau = this.getMonster(this.monster).move(this.tableau, "UP");
				}
				
				else if(this.isMovePossible(this.getMonster(this.monster).getY()+1, this.getMonster(this.monster).getX()))
				{
					this.tableau = this.getMonster(this.monster).move(this.tableau, "DOWN");
				}
			}
		
			else if(this.getMonster(this.monster).getX() < this.getHero().getX())
			{
				if(this.isMovePossible(this.getMonster(this.monster).getY(), this.getMonster(this.monster).getX()+1))
				{
					this.tableau = this.getMonster(this.monster).move(this.tableau, "RIGHT");
				}
			}
			
			else if(this.getMonster(this.monster).getY() < this.getHero().getY())
			{
				if(this.isMovePossible(this.getMonster(this.monster).getY()+1, this.getMonster(this.monster).getX()))
				{	
					this.tableau = this.getMonster(this.monster).move(this.tableau, "DOWN");
				}
			}
			
			else if(this.getMonster(this.monster).getY() > this.getHero().getY())
			{
				if(this.isMovePossible(this.getMonster(this.monster).getY()-1, this.getMonster(this.monster).getX()))
				{
					this.tableau = this.getMonster(this.monster).move(this.tableau, "UP");
				}
			}			
		}
	}
	
	public void setLastMove(String lastKey)
	{
		this.getMAP().setLastKey(lastKey);
	}
    
    public String getLastMove()
    {
    	return this.getMAP().getLastKey();
    }

	public void shoot() 
	{		
		if(this.getMAP().getFire() == 1)
		{
			this.getMAP().setFire(0);
			
			if(getLastMove() == "LEFT")
			{			
				if(this.isMovePossible(this.getHero().getY(), this.getHero().getX()-1))
				{
					this.getShoot().setX(this.getHero().getX()-1);
					this.getShoot().setY(this.getHero().getY());
					this.tableau[this.getHero().getY()][this.getHero().getX()-1] = 'F';
					this.getMAP().setFireDirection("LEFT");
				}
				
				else
				{
					this.getShoot().setX(this.getHero().getX()+1);
					this.getShoot().setY(this.getHero().getY());
					this.tableau[this.getHero().getY()][this.getHero().getX()+1] = 'F';
					this.getMAP().setFireDirection("RIGHT");
				}
			}
			
			else if(getLastMove() == "RIGHT")
			{			
				if(this.isMovePossible(this.getHero().getY(), this.getHero().getX()+1))
				{
					this.getShoot().setX(this.getHero().getX()+1);
					this.getShoot().setY(this.getHero().getY());
					this.tableau[this.getHero().getY()][this.getHero().getX()+1] = 'F';
					this.getMAP().setFireDirection("RIGHT");
				}
				
				else
				{
					this.getShoot().setX(this.getHero().getX()-1);
					this.getShoot().setY(this.getHero().getY());
					this.tableau[this.getHero().getY()][this.getHero().getX()-1] = 'F';
					this.getMAP().setFireDirection("LEFT");
				}
			}
			
			else if(getLastMove() == "UP")
			{			
				if(this.isMovePossible(this.getHero().getY()-1, this.getHero().getX()))
				{
					this.getShoot().setX(this.getHero().getX());
					this.getShoot().setY(this.getHero().getY()-1);
					this.tableau[this.getHero().getY()-1][this.getHero().getX()] = 'F';
					this.getMAP().setFireDirection("UP");
				}
				
				else
				{
					this.getShoot().setX(this.getHero().getX());
					this.getShoot().setY(this.getHero().getY()+1);
					this.tableau[this.getHero().getY()+1][this.getHero().getX()] = 'F';
					this.getMAP().setFireDirection("DOWN");
				}
			}
			
			else if(getLastMove() == "DOWN")
			{		
				if(this.isMovePossible(this.getHero().getY()+1, this.getHero().getX()))
				{
					this.getShoot().setX(this.getHero().getX());
					this.getShoot().setY(this.getHero().getY()+1);
					this.tableau[this.getHero().getY()+1][this.getHero().getX()] = 'F';
					this.getMAP().setFireDirection("DOWN");
				}
				
				else
				{
					this.getShoot().setX(this.getHero().getX());
					this.getShoot().setY(this.getHero().getY()-1);
					this.tableau[this.getHero().getY()-1][this.getHero().getX()] = 'F';
					this.getMAP().setFireDirection("UP");
				}
			}
			
			else if(getLastMove() == "DIAGOHD")
			{		
				if(this.isMovePossible(this.getHero().getY()-1, this.getHero().getX()+1))
				{
					this.getShoot().setX(this.getHero().getX()+1);
					this.getShoot().setY(this.getHero().getY()-1);
					this.tableau[this.getHero().getY()-1][this.getHero().getX()+1] = 'F';
					this.getMAP().setFireDirection("DIAGOHD");
				}
				
				else
				{
					this.getShoot().setX(this.getHero().getX()-1);
					this.getShoot().setY(this.getHero().getY()-1);
					this.tableau[this.getHero().getY()-1][this.getHero().getX()-1] = 'F';
					this.getMAP().setFireDirection("DIAGOHG");
				}
			}
			
			else if(getLastMove() == "DIAGOBG")
			{		
				if(this.isMovePossible(this.getHero().getY()+1, this.getHero().getX()-1))
				{
					this.getShoot().setX(this.getHero().getX()-1);
					this.getShoot().setY(this.getHero().getY()+1);
					this.tableau[this.getHero().getY()+1][this.getHero().getX()-1] = 'F';
					this.getMAP().setFireDirection("DIAGOBG");
				}
				
				else
				{
					this.getShoot().setX(this.getHero().getX()+1);
					this.getShoot().setY(this.getHero().getY()+1);
					this.tableau[this.getHero().getY()+1][this.getHero().getX()+1] = 'F';
					this.getMAP().setFireDirection("DIAGOBD");
				}
			}
			
			else if(getLastMove() == "DIAGOHG")
			{		
				if(this.isMovePossible(this.getHero().getY()-1, this.getHero().getX()-1))
				{
					this.getShoot().setX(this.getHero().getX()-1);
					this.getShoot().setY(this.getHero().getY()-1);
					this.tableau[this.getHero().getY()-1][this.getHero().getX()-1] = 'F';
					this.getMAP().setFireDirection("DIAGOHG");
				}
				
				else
				{
					this.getShoot().setX(this.getHero().getX()+1);
					this.getShoot().setY(this.getHero().getY()-1);
					this.tableau[this.getHero().getY()-1][this.getHero().getX()+1] = 'F';
					this.getMAP().setFireDirection("DIAGOHD");
				}
			}
			
			else if(getLastMove() == "DIAGOBD")
			{		
				if(this.isMovePossible(this.getHero().getY()+1, this.getHero().getX()+1))
				{
					this.getShoot().setX(this.getHero().getX()+1);
					this.getShoot().setY(this.getHero().getY()+1);
					this.tableau[this.getHero().getY()+1][this.getHero().getX()+1] = 'F';
					this.getMAP().setFireDirection("DIAGOBD");
				}
				
				else
				{
					this.getShoot().setX(this.getHero().getX()-1);
					this.getShoot().setY(this.getHero().getY()+1);
					this.tableau[this.getHero().getY()+1][this.getHero().getX()-1] = 'F';
					this.getMAP().setFireDirection("DIAGOBG");
				}
			}
		}
	}
	
	public void animateFire()
	{
		if(this.getMAP().getFire() == 0)
		{
			if(this.getMAP().getFireDirection() == "RIGHT")
			{
				if(this.isMovePossible(this.getShoot().getY(), this.getShoot().getX()+1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getShoot().moveRight();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY(), this.getShoot().getX()-1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';					
					this.getMAP().setFireDirection("LEFT");
					this.getShoot().moveLeft();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
			}
			
			else if(this.getMAP().getFireDirection() == "LEFT")
			{
				if(this.isMovePossible(this.getShoot().getY(), this.getShoot().getX()-1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getShoot().moveLeft();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY(), this.getShoot().getX()+1))
				{
					
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("RIGHT");				
					this.getShoot().moveRight();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
			}
			
			else if(this.getMAP().getFireDirection() == "UP")
			{
				if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getShoot().moveUp();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("DOWN");					
					this.getShoot().moveDown();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
			}
			
			else if(this.getMAP().getFireDirection() == "DOWN")
			{
				if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getShoot().moveDown();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("UP");
					this.getShoot().moveUp();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
			}
			
			else if(this.getMAP().getFireDirection()== "DIAGOHD")
			{
				if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()+1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getShoot().moveUp();
					this.getShoot().moveRight();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()-1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("DIAGOHG");
					this.getShoot().moveUp();
					this.getShoot().moveLeft();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()+1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("DIAGOBD");
					this.getShoot().moveDown();
					this.getShoot().moveRight();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()-1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("DIAGOBG");
					this.getShoot().moveDown();
					this.getShoot().moveLeft();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
			}
			
			else if(this.getMAP().getFireDirection() == "DIAGOBG")
			{
				if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()-1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getShoot().moveDown();
					this.getShoot().moveLeft();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}				
				
				else if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()-1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("DIAGOHG");
					this.getShoot().moveUp();
					this.getShoot().moveLeft();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()+1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("DIAGOBD");
					this.getShoot().moveDown();
					this.getShoot().moveRight();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()+1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("DIAGOHD");
					this.getShoot().moveUp();
					this.getShoot().moveRight();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
			}			
		
			else if(this.getMAP().getFireDirection() == "DIAGOHG")
			{
				if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()-1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getShoot().moveUp();
					this.getShoot().moveLeft();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()-1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("DIAGOBG");
					this.getShoot().moveDown();
					this.getShoot().moveLeft();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()+1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("DIAGOHD");
					this.getShoot().moveUp();
					this.getShoot().moveRight();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()+1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("DIAGOBD");
					this.getShoot().moveDown();
					this.getShoot().moveRight();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
			}
			
			else if(this.getMAP().getFireDirection()== "DIAGOBD")
			{
				if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()+1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getShoot().moveDown();
					this.getShoot().moveRight();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()+1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("DIAGOHD");
					this.getShoot().moveUp();
					this.getShoot().moveRight();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()-1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("DIAGOBG");
					this.getShoot().moveDown();
					this.getShoot().moveLeft();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
				
				else if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()-1))
				{
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = ' ';
					this.getMAP().setFireDirection("DIAGOHG");
					this.getShoot().moveUp();
					this.getShoot().moveLeft();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
			}
		}
	}
	
	public boolean checkPosition()
	{
		if(this.getHero().getX() == this.getMonster(this.monster).getX() && this.getHero().getY() == this.getMonster(this.monster).getY())
		{
			return true;
		}
		
		if(this.getHero().getX() == this.getMonster(this.monster2).getX() && this.getHero().getY() == this.getMonster(this.monster2).getY())
		{
			return true;
		}
		
		if(this.getHero().getX() == this.getMonster(this.monster3).getX() && this.getHero().getY() == this.getMonster(this.monster3).getY())
		{
			return true;
		}
		
		if(this.getHero().getX() == this.getMonster(this.monster4).getX() && this.getHero().getY() == this.getMonster(this.monster4).getY())
		{
			return true;
		}
		
		if(this.getHero().getX() == this.getShoot().getX() && this.getHero().getY() == this.getShoot().getY())
		{
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
			this.getMAP().setFire(1);;
		}
		
		if(this.getShoot().getX() == this.getMonster(this.monster).getX() && this.getShoot().getY() == this.getMonster(this.monster).getY())
		{
			this.tableau[this.getMonster(this.monster).getY()][this.getMonster(this.monster).getX()] = ' ';
			this.getMAP().setFire(1);
			this.getMonster(this.monster).setDeath(1);
			this.getMonster(this.monster).setX(0);
			this.getMonster(this.monster).setY(0);
			this.getMAP().setScore(this.getMAP().getScore() + 250);
		}
		
		if(this.getShoot().getX() == this.getMonster(this.monster2).getX() && this.getShoot().getY() == this.getMonster(this.monster2).getY())
		{
			this.tableau[this.getMonster(this.monster2).getY()][this.getMonster(this.monster2).getX()] = ' ';
			this.getMAP().setFire(1);
			this.getMonster(this.monster2).setDeath(1);
			this.getMonster(this.monster2).setX(0);
			this.getMonster(this.monster2).setY(0);
			this.getMAP().setScore(this.getMAP().getScore() + 250);
		}
		
		if(this.getShoot().getX() == this.getMonster(this.monster3).getX() && this.getShoot().getY() == this.getMonster(this.monster3).getY())
		{
			this.tableau[this.getMonster(this.monster3).getY()][this.getMonster(this.monster3).getX()] = ' ';
			this.getMAP().setFire(1);
			this.getMonster(this.monster3).setDeath(1);
			this.getMonster(this.monster3).setX(0);
			this.getMonster(this.monster3).setY(0);
			this.getMAP().setScore(this.getMAP().getScore() + 250);
		}
		
		if(this.getShoot().getX() == this.getMonster(this.monster4).getX() && this.getShoot().getY() == this.getMonster(this.monster4).getY())
		{
			this.tableau[this.getMonster(this.monster4).getY()][this.getMonster(this.monster4).getX()] = ' ';
			this.getMAP().setFire(1);
			this.getMonster(this.monster4).setDeath(1);
			this.getMonster(this.monster4).setX(0);
			this.getMonster(this.monster4).setY(0);
			this.getMAP().setScore(this.getMAP().getScore() + 250);
		}
		
		if(this.getHero().getX() == this.getMAP().getEnergyX() && this.getHero().getY() == this.getMAP().getEnergyY())
		{
			this.getMAP().setEnergyX(0);
			this.getMAP().setEnergyY(0);
			this.tableau[this.getMAP().getGateY()][this.getMAP().getGateX()] = 'C';
			this.getMAP().setScore(this.getMAP().getScore() + 50);
		}
		
		if(this.getHero().getX() == this.getMAP().getGateX() && this.getHero().getY() == this.getMAP().getGateY())
		{
			if(this.getMAP().getGateOpen() == 0)
			{
				return true;
			}
			
			else
			{
				// WIN
				this.getMAP().setGateX(0);
				this.getMAP().setGateY(0);
				this.getMAP().setScore(this.getMAP().getScore() + 500);
			}
		}
		
		return false;
	}

	public void moveDiagoHD() {
		if(this.isMovePossible2(this.getHero().getY()-1, this.getHero().getX()+1))
		{
			if(this.getElement(this.getHero().getY()-1, this.getHero().getX()+1) == 'p')
			{
				this.getMAP().setScore(this.getMAP().getScore() + 100);			
			}
			
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveUp();	
			this.getHero().moveRight();
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
	}

	public void moveDiagoHG() {
		if(this.isMovePossible2(this.getHero().getY()-1, this.getHero().getX()-1))
		{
			if(this.getElement(this.getHero().getY()-1, this.getHero().getX()-1) == 'p')
			{
				this.getMAP().setScore(this.getMAP().getScore() + 100);		
			}
			
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveUp();	
			this.getHero().moveLeft();
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
	}

	public void moveDiagoBD() {
		if(this.isMovePossible2(this.getHero().getY()+1, this.getHero().getX()+1))
		{
			if(this.getElement(this.getHero().getY()+1, this.getHero().getX()+1) == 'p')
			{
				this.getMAP().setScore(this.getMAP().getScore() + 100);		
			}
			
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveDown();	
			this.getHero().moveRight();
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
	}

	public void moveDiagoBG() {
		if(this.isMovePossible2(this.getHero().getY()+1, this.getHero().getX()-1))
		{
			if(this.getElement(this.getHero().getY()+1, this.getHero().getX()-1) == 'p')
			{
				this.getMAP().setScore(this.getMAP().getScore() + 100);		
			}
			
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveDown();	
			this.getHero().moveLeft();
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
	}


}
