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
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
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
	
	/** Level */
	private int level;
	
	/** Hero */
	public Hero hero;
	
	/** Array of monster. */
	public Monster monsters[];
	
	/** The first monster. */
	public Monster monster1;
	
	/** The second monster. */
	public Monster monster2;
	
	/** The third monster. */
	public Monster monster3;
	
	/** The forth monster. */
	public Monster monster4;
	
	/** The shoot. */
	public Shoot shoot;
	
	/** The . */
	public ElementLevel elementLevel;
	
	/** The table for the map. */
	private char[][] tableau = new char[this.getWidth()+1][this.getHeight()+1];
	
	/** The name of the player */
	private String[] DBplayerName = new String[6];
	
	/** The score of the player */
    private int[] DBplayerScore = new int[6];
	
	
/////////////////////////////////////////////////////////GETTERS//////////////////////////////////////////////////////////////

    /** 
     * Gets the name of the player
     * 
     *   @param i
     *   
     *   @ return DBplayerName
     *   				the name of the player
     */
    public String getDBplayerName(int i) {
        return this.DBplayerName[i];
    }
    
    /** 
     * Gets the score of the player
     * 
     *   @param i
     *   
     *   @ return DBplayerScore
     *   				the score of the player at the end of the game
     */
    public int getDBplayerScore(int i) {
        return this.DBplayerScore[i];
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
	 * Gets the score
	 * 
	 * @return getElementLevel().getScore()
	 * 				the score during the game
	 * 
	 */
	public int getScore()
	{
		return this.getElementLevel().getScore();
	}
	
	/** 
	 * Gets the level
	 * 
	 * @return level
	 * 				the level
	 * 
	 */
	public int getLevel()
	{
		return this.level;
	}
	
	/**  
	 * Gets the hero
	 * 
	 * @return hero
	 * 			the hero
	 * 
	 */
	public Hero getHero() {
		return this.hero;
	}
    
	/**  
	 * Gets the monster
	 * 
	 * @param monster
	 * 			the monster
	 * 
	 * @return monster
	 * 			the monster
	 * 
	 */
    public Monster getMonster(Monster monster) {
		return monster;
	}
    
    /**  
	 * Gets the shoot
	 * 
	 * @return shoot
	 * 			the shoot
	 * 
	 */
    public Shoot getShoot()
    {
    	return this.shoot;
    }
    
    /**  
	 * Gets an element in a level
	 * 
	 * @return elementLevel
	 * 			the element level
	 * 
	 */
	public ElementLevel getElementLevel() {
		return this.elementLevel;
	}
	
	/**  
	 * Gets the width of the map
	 * 
	 * @return width
	 * 			the width of the map
	 * 
	 */
	public int getWidth()
	{
		return this.width;
	}
	
	/**  
	 * Gets the height of the map
	 * 
	 * @return height
	 * 			the height of the map
	 * 
	 */
	public int getHeight()
	{
		return this.height;
	}
	
	/**  
	 * Gets the array with the map
	 * 
	 * @return tableau
	 * 			the array with the map
	 * 
	 */
	public char[][] getMap() {
        return this.tableau;
    }
	
	/**  
	 * Gets an element on the map
	 * 
	 * @return tableau[x][y]
	 * 				the place of an element in the array which correspond to the map
	 * 
	 */
	public char getElement(int x, int y){
		if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())) {
			return (Character) null;
		}
		return this.tableau[x][y];
	}
	////////////////////////////////////////////////////////////
	 /**  
	 * Gets 
	 * 
	 * @return 
	 * 
	 */
	public int getLoadMap()
    {
    	return this.getElementLevel().getLoadMap();
    }
	
	/**  
	 * Gets the last movement
	 * 
	 * @return getElementLevel().getLastKey()
	 * 				the last movement
	 * 
	 */
	public String getLastMove()
    {
    	return this.getElementLevel().getLastKey();
    }

/////////////////////////////////////////////////////////SETTERS//////////////////////////////////////////////////////////////

    /** 
     * Set the name of the player
     * 
     *   @param DBplayerName
     *   			The name of the player
     *   
     */
    public void setDBplayerName(String DBplayerName[]) {
        this.DBplayerName = DBplayerName;
    }

    /** 
     * Set the score of the player
     * 
     *   @param DBplayerScore
     *   			The score of the player
     *   
     */
    public void setDBplayerScore(int DBplayerScore[]) {
        this.DBplayerScore = DBplayerScore;
    }
	
    /** 
     * Set the player
     * 
     *   @param name
     *   		the name of the player
     *   @param score
     *   		the score of the player
     *   
     */
    private void setDBplayer(final String[] name, final int[] score) {
        this.setDBplayerName(name);
        this.setDBplayerScore(score);
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

	/**
	 * Sets the level.
	 *
	 * @param level
	 *          the new level
	 */
	public void setLevel(int level)
	{
		this.level = level;
	}
	
	/**
	 * Sets the map.
	 *
	 * @param map
	 *          the new map
	 */
	 private void setMap(final String map) {
	     this.map = map;
	     this.setChanged();
	     this.notifyObservers();
	 }
	 
	/**
	* Sets the mobile.
	*/
	public void setMobileHasChanged(){
	    this.setChanged();
	    this.notifyObservers();
	}
	
	/**
	 * Sets the last movement.
	 *
	 * @param lastKey
	 *          the last key which were pressed by the player
	 */
	public void setLastMove(String lastKey)
	{
		this.getElementLevel().setLastKey(lastKey);
	}

///////////////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////////////

    /**
	 * Instantiates a new model.
	 */
	public Model() {
		this.map = ""; //instanciate attribut map
		this.hero = new Hero(0, 0); //instanciate an hero

		this.monster1 = new Monster(0, 1);
		this.monster2 = new Monster(0, 2);
		this.monster3 = new Monster(0, 3);
		this.monster4 = new Monster(0, 4);
		
		this.monsters = new Monster[]{this.monster1, this.monster2, this.monster3, this.monster4};

		this.shoot = new Shoot(1, 1);
		this.elementLevel = new ElementLevel(); //instanciate a new element
		this.message = "";
	}


////////////////////////////////////////////////////////METHODS///////////////////////////////////////////////////////////////

    /**  
     * Load the highscores
     * 
     */
    public void loadHighscore() {
        try {
            final DAOScore daoScore = new DAOScore(DBConnection.getInstance().getConnection());
            this.setDBplayer(daoScore.putHighscores().getName(),daoScore.putHighscores().getScore());
        } catch (final SQLException e) {
            e.printStackTrace();
        }
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
	
	/**
	 * Insert a score in the DataBase
	 * 
	 */
	public void InsertScore(final String name, final int score) {
		try {
			final DAOScore daoScore = new DAOScore(DBConnection.getInstance().getConnection());
			daoScore.SaveScore(name, score);
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
	
	
	/**
	 * Fill an array with data in database
	 * 
	 */
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
                    	this.getElementLevel().setGateX(j);
                    	this.getElementLevel().setGateY(i);
                    	//System.out.print(this.tableau[i][j]);
                    break;
                    
                    case 'e':                       
                    	this.tableau[i][j] = 'e'; 
                    	this.getElementLevel().setEnergyX(j);
                    	this.getElementLevel().setEnergyY(i);
                    	//System.out.print(this.tableau[i][j]);
                    break;
                    
                    case 'l':                       
                    	this.tableau[i][j] = 'l';
                    	this.hero.setX(j);
                    	this.hero.setY(i);   
                    break;
                    
                    case '1':
                    	this.tableau[i][j] = '1';
                    	this.monster1.setX(j);
                    	this.monster1.setY(i);
                    	this.getMonster(this.monster1).setDeath(0);
                    break;
                    
                    case '2':
                    	this.tableau[i][j] = '2';
                    	this.monster2.setX(j);
                    	this.monster2.setY(i);
                    	this.getMonster(this.monster2).setDeath(0);
                    break;
                    
                    case '3':
                    	this.tableau[i][j] = '3';
                    	this.monster3.setX(j);
                    	this.monster3.setY(i);
                    	this.getMonster(this.monster3).setDeath(0);
                    break;
                    
                    case '4':
                    	this.tableau[i][j] = '4';
                    	this.monster4.setX(j);
                    	this.monster4.setY(i);
                    	this.getMonster(this.monster4).setDeath(0);
                    break;
                    
                    default:
                    	this.tableau[i][j] = ' ';   
                    	//System.out.print(this.tableau[i][j]);
                    break;
                }     
            }
        }
	}
	
	/**
	 * Check if the movement is possible
	 * 
	 */
	public boolean isMovePossible(final int x, final int y) {
		if(this.getElement(x, y) == 'h' || this.getElement(x, y) == 'v' || this.getElement(x, y) == 'b' || this.getElement(x, y) == 'p' || this.getElement(x, y) == 'e' || this.getElement(x, y) == 'c' || this.getElement(x, y) == 'C'){
			return false;
		}else{
			return true;
		}
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean isMovePossible2(final int x, final int y) {
		if(this.getElement(x, y) == 'h' || this.getElement(x, y) == 'v' || this.getElement(x, y) == 'b'){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * Move an hero in the array
	 * 
	 */
	public void moveHero(String move)
	{
		if(this.isMovePossible2(this.getHero().getY()-1, this.getHero().getX()) && move == "UP")
		{
			if(this.getElement(this.getHero().getY()-1, this.getHero().getX()) == 'p')
			{
				this.getElementLevel().setScore(this.getElementLevel().getScore() + 100);		
			}
			
			this.tableau = this.getHero().move(this.tableau, "UP");				
		}
		
		else if(this.isMovePossible2(this.getHero().getY(), this.getHero().getX()-1) && move == "LEFT")
		{
			if(this.getElement(this.getHero().getY(), this.getHero().getX()-1) == 'p')
			{
				this.getElementLevel().setScore(this.getElementLevel().getScore() + 100);			
			}
			
			this.tableau = this.getHero().move(this.tableau, "LEFT");			
		}
		
		else if(this.isMovePossible2(this.getHero().getY(), this.getHero().getX()+1) && move == "RIGHT")
		{
			if(this.getElement(this.getHero().getY(), this.getHero().getX()+1) == 'p')
			{
				this.getElementLevel().setScore(this.getElementLevel().getScore() + 100);			
			}
			
			this.tableau = this.getHero().move(this.tableau, "RIGHT");
		}
		
		else if(this.isMovePossible2(this.getHero().getY()+1, this.getHero().getX()) && move == "DOWN")
		{
			if(this.getElement(this.getHero().getY()+1, this.getHero().getX()) == 'p')
			{
				this.getElementLevel().setScore(this.getElementLevel().getScore() + 100);			
			}
			
			this.tableau = this.getHero().move(this.tableau, "DOWN");
		}
	}
	
	/**
	 * Load the map from the data base.
	 *
	 * @param key
	 *          the key of the map we would like to read in the database
	 */ 
    public void loadMap2(String key) {
        try {
            final DAOLoadMap daoLoadMap = new DAOLoadMap(DBConnection.getInstance().getConnection());
            this.setMap(daoLoadMap.find(key).getMap());
            this.getElementLevel().setLoadMap(1);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    /**
	 * Move a monster in the array
	 * 
	 */
	public void moveMonster() 
	{		
		for(Monster m :this.monsters)
		{
			if(this.getMonster(m).getDeath() == 0)
			{
				if(this.getMonster(m).getX() > this.getHero().getX())
				{
					if(this.isMovePossible(this.getMonster(m).getY(), this.getMonster(m).getX()-1))
					{
						this.tableau = this.getMonster(m).move(this.tableau, "LEFT");
					}
					
					else if(this.getMonster(m).getY() > this.getHero().getY())
					{
						if(this.isMovePossible(this.getMonster(m).getY()-1, this.getMonster(m).getX()))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "UP");
						}
						
						if(this.isMovePossible(this.getMonster(m).getY(), this.getMonster(m).getX()-1))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "LEFT");
						}
					}
						
					else
					{
						if(this.isMovePossible(this.getMonster(m).getY()+1, this.getMonster(m).getX()))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "DOWN");
						}
						
						if(this.isMovePossible(this.getMonster(m).getY(), this.getMonster(m).getX()-1))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "LEFT");
						}
					}
				}
				
				else if(this.getMonster(m).getX() < this.getHero().getX())
				{
					if(this.isMovePossible(this.getMonster(m).getY(), this.getMonster(m).getX()+1))
					{
						this.tableau = this.getMonster(m).move(this.tableau, "RIGHT");
					}
					
					else if(this.getMonster(m).getY() > this.getHero().getY())
					{
						if(this.isMovePossible(this.getMonster(m).getY()-1, this.getMonster(m).getX()))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "UP");
						}
						
						if(this.isMovePossible(this.getMonster(m).getY(), this.getMonster(m).getX()+1))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "RIGHT");
						}
					}
						
					else
					{
						if(this.isMovePossible(this.getMonster(m).getY()+1, this.getMonster(m).getX()))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "DOWN");
						}
						
						if(this.isMovePossible(this.getMonster(m).getY(), this.getMonster(m).getX()+1))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "RIGHT");
						}
					}
				}
					
				else if(this.getMonster(m).getY() < this.getHero().getY())
				{
					if(this.isMovePossible(this.getMonster(m).getY()+1, this.getMonster(m).getX()))
					{
						this.tableau = this.getMonster(m).move(this.tableau, "DOWN");
					}
					
					else if(this.getMonster(m).getX() > this.getHero().getX())
					{
						if(this.isMovePossible(this.getMonster(m).getY(), this.getMonster(m).getX()-1))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "LEFT");
						}
						
						if(this.isMovePossible(this.getMonster(m).getY()+1, this.getMonster(m).getX()))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "DOWN");
						}
					}
						
					else
					{
						if(this.isMovePossible(this.getMonster(m).getY(), this.getMonster(m).getX()+1))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "RIGHT");
						}
						
						if(this.isMovePossible(this.getMonster(m).getY()+1, this.getMonster(m).getX()))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "DOWN");
						}
					}
				}
					
				else if(this.getMonster(m).getY() > this.getHero().getY())
				{
					if(this.isMovePossible(this.getMonster(m).getY()-1, this.getMonster(m).getX()))
					{
						this.tableau = this.getMonster(m).move(this.tableau, "UP");
					}
					
					else if(this.getMonster(m).getX() > this.getHero().getX())
					{
						if(this.isMovePossible(this.getMonster(m).getY(), this.getMonster(m).getX()-1))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "LEFT");
						}
						
						if(this.isMovePossible(this.getMonster(m).getY()-1, this.getMonster(m).getX()))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "UP");
						}
					}
						
					else
					{
						if(this.isMovePossible(this.getMonster(m).getY(), this.getMonster(m).getX()+1))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "RIGHT");
						}
						
						if(this.isMovePossible(this.getMonster(m).getY()-1, this.getMonster(m).getX()))
						{
							this.tableau = this.getMonster(m).move(this.tableau, "UP");
						}
					}
				}			
			}
		}
	}
	
	
	/**
	 * Shoot with a fireball
	 * 
	 */
	public void shoot() 
	{		
		if(this.getElementLevel().getFire() == 1)
		{
			this.getElementLevel().setFire(0);
			
			if(getLastMove() == "LEFT")
			{	
				if(this.isMovePossible(this.getHero().getY(), this.getHero().getX()-1))
				{
					this.tableau = this.getShoot().move(this.tableau, "LEFT", this.getHero().getY(), this.getHero().getX()-1);
				}
				
				else
				{
					this.tableau = this.getShoot().move(this.tableau, "RIGHT", this.getHero().getY(), this.getHero().getX()+1);
				}
			}
			
			else if(getLastMove() == "RIGHT")
			{			
				if(this.isMovePossible(this.getHero().getY(), this.getHero().getX()+1))
				{
					this.tableau = this.getShoot().move(this.tableau, "RIGHT", this.getHero().getY(), this.getHero().getX()+1);
				}
				
				else
				{
					this.tableau = this.getShoot().move(this.tableau, "LEFT", this.getHero().getY(), this.getHero().getX()-1);
				}
			}
			
			else if(getLastMove() == "UP")
			{			
				if(this.isMovePossible(this.getHero().getY()-1, this.getHero().getX()))
				{
					this.tableau = this.getShoot().move(this.tableau, "UP", this.getHero().getY()-1, this.getHero().getX());
				}
				
				else
				{
					this.tableau = this.getShoot().move(this.tableau, "DOWN", this.getHero().getY()+1, this.getHero().getX());
				}
			}
			
			else if(getLastMove() == "DOWN")
			{		
				if(this.isMovePossible(this.getHero().getY()+1, this.getHero().getX()))
				{
					this.tableau = this.getShoot().move(this.tableau, "DOWN", this.getHero().getY()+1, this.getHero().getX());
				}
				
				else
				{
					this.tableau = this.getShoot().move(this.tableau, "UP", this.getHero().getY()-1, this.getHero().getX());
				}
			}
			
			else if(getLastMove() == "DIAGOHD")
			{		
				if(this.isMovePossible(this.getHero().getY()-1, this.getHero().getX()+1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOHD", this.getHero().getY()-1, this.getHero().getX()+1);
				}
				
				else
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOHG", this.getHero().getY()-1, this.getHero().getX()-1);
				}
			}
			
			else if(getLastMove() == "DIAGOBG")
			{		
				if(this.isMovePossible(this.getHero().getY()+1, this.getHero().getX()-1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOBG", this.getHero().getY()+1, this.getHero().getX()-1);
				}
				
				else
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOBD", this.getHero().getY()+1, this.getHero().getX()+1);
				}
			}
			
			else if(getLastMove() == "DIAGOHG")
			{		
				if(this.isMovePossible(this.getHero().getY()-1, this.getHero().getX()-1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOHG", this.getHero().getY()-1, this.getHero().getX()-1);
				}
				
				else
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOBG", this.getHero().getY()+1, this.getHero().getX()-1);
				}
			}
			
			else if(getLastMove() == "DIAGOBD")
			{		
				if(this.isMovePossible(this.getHero().getY()+1, this.getHero().getX()+1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOBD", this.getHero().getY()+1, this.getHero().getX()+1);
				}
				
				else
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOHD", this.getHero().getY()-1, this.getHero().getX()+1);
				}
			}
		}
	}
	
	/**
	 * Animate the fireball
	 * 
	 */
	public void animateFire()
	{
		if(this.getElementLevel().getFire() == 0)
		{
			if(this.getShoot().getFireDirection() == "RIGHT")
			{
				if(this.isMovePossible(this.getShoot().getY(), this.getShoot().getX()+1))
				{
					this.tableau = this.getShoot().move(this.tableau, "RIGHT");
				}
				
				else if(this.isMovePossible(this.getShoot().getY(), this.getShoot().getX()-1))
				{
					this.tableau = this.getShoot().move(this.tableau, "LEFT");
				}
			}
			
			else if(this.getShoot().getFireDirection() == "LEFT")
			{
				if(this.isMovePossible(this.getShoot().getY(), this.getShoot().getX()-1))
				{
					this.tableau = this.getShoot().move(this.tableau, "LEFT");
				}
				
				else if(this.isMovePossible(this.getShoot().getY(), this.getShoot().getX()+1))
				{
					
					this.tableau = this.getShoot().move(this.tableau, "RIGHT");
				}
			}
			
			else if(this.getShoot().getFireDirection() == "UP")
			{
				if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()))
				{
					this.tableau = this.getShoot().move(this.tableau, "UP");
				}
				
				else if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()))
				{
					this.tableau = this.getShoot().move(this.tableau, "DOWN");
				}
			}
			
			else if(this.getShoot().getFireDirection() == "DOWN")
			{
				if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()))
				{
					this.tableau = this.getShoot().move(this.tableau, "DOWN");
				}
				
				else if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()))
				{
					this.tableau = this.getShoot().move(this.tableau, "UP");
				}
			}
			
			else if(this.getShoot().getFireDirection()== "DIAGOHD")
			{
				if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()+1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOHD");
				}
				
				else if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()-1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOHG");
				}
				
				else if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()+1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOBD");
				}
				
				else if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()-1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOBG");
				}
			}
			
			else if(this.getShoot().getFireDirection() == "DIAGOBG")
			{
				if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()-1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOBG");
				}				
				
				else if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()-1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOHG");
				}
				
				else if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()+1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOBD");
				}
				
				else if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()+1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOHD");
				}
			}			
		
			else if(this.getShoot().getFireDirection() == "DIAGOHG")
			{
				if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()-1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOHG");
				}
				
				else if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()+1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOHD");
				}
				
				else if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()-1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOBG");
				}
				
				else if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()+1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOBD");
				}
				
			}
			
			else if(this.getShoot().getFireDirection()== "DIAGOBD")
			{
				if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()+1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOBD");
				}
				
				else if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()+1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOHD");
				}
				
				else if(this.isMovePossible(this.getShoot().getY()+1, this.getShoot().getX()-1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOBG");
				}
				
				else if(this.isMovePossible(this.getShoot().getY()-1, this.getShoot().getX()-1))
				{
					this.tableau = this.getShoot().move(this.tableau, "DIAGOHG");
				}
			}
		}
	}
	
	/**
	 * Check the position of the monster compared to the hero
	 * 
	 */
	public boolean checkPosition()
	{
		for(Monster m : this.monsters)
		{
			if(this.getHero().getX() == this.getMonster(m).getX() && this.getHero().getY() == this.getMonster(m).getY())
			{
				return true;
			}
		}
		
		if(this.getHero().getX() == this.getShoot().getX() && this.getHero().getY() == this.getShoot().getY())
		{
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
			this.getElementLevel().setFire(1);
		}
		
		for(Monster m : this.monsters)
		{
			if(this.getShoot().getX() == this.getMonster(m).getX() && this.getShoot().getY() == this.getMonster(m).getY())
			{
				this.tableau[this.getMonster(m).getY()][this.getMonster(m).getX()] = ' ';
				this.getElementLevel().setFire(1);
				this.getMonster(m).setDeath(1);
				this.getMonster(m).setX(0);
				this.getMonster(m).setY(0);
				this.getElementLevel().setScore(this.getElementLevel().getScore() + 250);
			}
		}
		
		if(this.getHero().getX() == this.getElementLevel().getEnergyX() && this.getHero().getY() == this.getElementLevel().getEnergyY())
		{
			this.getElementLevel().setEnergyX(0);
			this.getElementLevel().setEnergyY(0);
			this.getElementLevel().setGateOpen(1);
			this.tableau[this.getElementLevel().getGateY()][this.getElementLevel().getGateX()] = 'C';
			this.getElementLevel().setScore(this.getElementLevel().getScore() + 50);
		}
		
		if(this.getHero().getX() == this.getElementLevel().getGateX() && this.getHero().getY() == this.getElementLevel().getGateY())
		{
			if(this.getElementLevel().getGateOpen() == 0)
			{
				return true;
			}
			
			else
			{
				for(Monster m : this.monsters)
				{
					this.getMonster(m).setDeath(1);
				}

				this.getElementLevel().setGateX(25);
				this.getElementLevel().setGateY(25);
				this.getElementLevel().setEnergyX(25);
				this.getElementLevel().setEnergyY(25);
				this.getElementLevel().setFire(1);
				this.getElementLevel().setGateOpen(0);
				this.getElementLevel().setScore(this.getElementLevel().getScore() + 500);
				
				if(this.level == 1)
				{					
					this.level = 2;
					this.loadMap2("TWO");	
				}
				
				else if(this.level == 2)
				{
					this.level = 3;
					this.loadMap2("THREE");
				}
				
				else if(this.level == 3)
				{
					this.level = 4;
					this.loadMap2("FOUR");
				}
				
				else if(this.level == 4)
				{
					this.level = 5;
					this.loadMap2("FIVE");
				}
				
				else if(this.level == 5)
				{
					System.out.print("Fini !");
				}
				
				this.getShoot().setX(this.getHero().getX());
				this.getShoot().setY(this.getHero().getY());
			}
		}
		
		return false;
	}
	
	/**
	 * Move in diagonal in the top right hand corner
	 * 
	 */
	public void moveDiagoHD() {
		if(this.isMovePossible2(this.getHero().getY()-1, this.getHero().getX()+1))
		{
			if(this.getElement(this.getHero().getY()-1, this.getHero().getX()+1) == 'p')
			{
				this.getElementLevel().setScore(this.getElementLevel().getScore() + 100);			
			}
			
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveUp();	
			this.getHero().moveRight();
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
	}
	
	/**
	 * Move in diagonal in the top left hand corner
	 * 
	 */
	public void moveDiagoHG() {
		if(this.isMovePossible2(this.getHero().getY()-1, this.getHero().getX()-1))
		{
			if(this.getElement(this.getHero().getY()-1, this.getHero().getX()-1) == 'p')
			{
				this.getElementLevel().setScore(this.getElementLevel().getScore() + 100);		
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
				this.getElementLevel().setScore(this.getElementLevel().getScore() + 100);		
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
				this.getElementLevel().setScore(this.getElementLevel().getScore() + 100);		
			}
			
			this.tableau[this.getHero().getY()][this.getHero().getX()] = ' ';
			this.getHero().moveDown();	
			this.getHero().moveLeft();
			this.tableau[this.getHero().getY()][this.getHero().getX()] = 'l';
		}
	}

}
