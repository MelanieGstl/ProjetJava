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
	public int monster_death;
	public int monster_death2;
	public int monster_death3;
	public int monster_death4;
	public Shoot shoot;
	public int energyX = 25;
	public int energyY = 25;
	public int gateX = 25;
	public int gateY = 25;
	public int gate_open = 0;
	public int you_can_fire = 1;	
	private String lastKey = "RIGHT";	
	public String fire_direction = "RIGHT";
	public int Score;
	
	private char[][] tableau = new char[this.getWidth()+1][this.getHeight()+1];
	
	public int getScore() {
		return this.Score;
	}
	
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
                    	this.gateX = j;
                    	this.gateY = i;
                    	//System.out.print(this.tableau[i][j]);
                    break;
                    
                    case 'e':                       
                    	this.tableau[i][j] = 'e'; 
                    	this.energyX = j;
                    	this.energyY = i;
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
				this.Score += 100;			
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
				this.Score += 100;			
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
				this.Score += 100;			
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
				this.Score += 100;			
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
    
    public void loadMap2(String key) {
        try {
            final DAOLoadMap daoLoadMap = new DAOLoadMap(DBConnection.getInstance().getConnection());
            this.setMap(daoLoadMap.find(key).getMap());
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

	public void moveMonster() {
		
		System.out.println("Score : "+this.Score);
		
		if(this.monster_death == 0)
		{
			if(this.getMonster(this.monster).getX() > this.getHero().getX())
			{
				if(this.isMovePossible(this.getMonster(this.monster).getY(), this.getMonster(this.monster).getX()-1))
				{
					this.tableau[this.getMonster(this.monster).getY()][this.getMonster(this.monster).getX()] = ' ';					
					this.getMonster(this.monster).moveLeft();		
					this.tableau[this.getMonster(this.monster).getY()][this.getMonster(this.monster).getX()] = '1';
				}
				
				else if(this.isMovePossible(this.getMonster(this.monster).getY()-1, this.getMonster(this.monster).getX()))
				{
					this.tableau[this.getMonster(this.monster).getY()][this.getMonster(this.monster).getX()] = ' ';
					this.getMonster(this.monster).moveUp();		
					this.tableau[this.getMonster(this.monster).getY()][this.getMonster(this.monster).getX()] = '1';
				}
				
				else if(this.isMovePossible(this.getMonster(this.monster).getY()+1, this.getMonster(this.monster).getX()))
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
	
	public void setLastMove(String lastKey)
	{
		this.lastKey = lastKey;
	}
    
    public String getLastMove()
    {
    	return this.lastKey;
    }

	public void shoot() 
	{		
		if(this.you_can_fire == 1)
		{
			this.you_can_fire = 0;
			
			if(getLastMove() == "LEFT")
			{			
				if(this.isMovePossible(this.getHero().getY(), this.getHero().getX()-1))
				{
					this.getShoot().setX(this.getHero().getX()-1);
					this.getShoot().setY(this.getHero().getY());
					this.tableau[this.getHero().getY()][this.getHero().getX()-1] = 'F';
					this.fire_direction = "LEFT";
				}
				
				else
				{
					this.getShoot().setX(this.getHero().getX()+1);
					this.getShoot().setY(this.getHero().getY());
					this.tableau[this.getHero().getY()][this.getHero().getX()+1] = 'F';
					this.fire_direction = "RIGHT";
				}
			}
			
			else if(getLastMove() == "RIGHT")
			{			
				if(this.isMovePossible(this.getHero().getY(), this.getHero().getX()+1))
				{
					this.getShoot().setX(this.getHero().getX()+1);
					this.getShoot().setY(this.getHero().getY());
					this.tableau[this.getHero().getY()][this.getHero().getX()+1] = 'F';
					this.fire_direction = "RIGHT";
				}
				
				else
				{
					this.getShoot().setX(this.getHero().getX()-1);
					this.getShoot().setY(this.getHero().getY());
					this.tableau[this.getHero().getY()][this.getHero().getX()-1] = 'F';
					this.fire_direction = "LEFT";
				}
			}
			
			else if(getLastMove() == "UP")
			{			
				if(this.isMovePossible(this.getHero().getY()-1, this.getHero().getX()))
				{
					this.getShoot().setX(this.getHero().getX());
					this.getShoot().setY(this.getHero().getY()-1);
					this.tableau[this.getHero().getY()-1][this.getHero().getX()] = 'F';
					this.fire_direction = "UP";
				}
				
				else
				{
					this.getShoot().setX(this.getHero().getX());
					this.getShoot().setY(this.getHero().getY()+1);
					this.tableau[this.getHero().getY()+1][this.getHero().getX()] = 'F';
					this.fire_direction = "DOWN";
				}
			}
			
			else if(getLastMove() == "DOWN")
			{		
				if(this.isMovePossible(this.getHero().getY()+1, this.getHero().getX()))
				{
					this.getShoot().setX(this.getHero().getX());
					this.getShoot().setY(this.getHero().getY()+1);
					this.tableau[this.getHero().getY()+1][this.getHero().getX()] = 'F';
					this.fire_direction = "down";
				}
				
				else
				{
					this.getShoot().setX(this.getHero().getX());
					this.getShoot().setY(this.getHero().getY()-1);
					this.tableau[this.getHero().getY()-1][this.getHero().getX()] = 'F';
					this.fire_direction = "UP";
				}
			}
		}
	}
	
	public void animateFire()
	{
		if(this.you_can_fire == 0)
		{
			if(this.fire_direction == "RIGHT")
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
					this.fire_direction = "LEFT";
					this.getShoot().moveLeft();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
			}
			
			else if(this.fire_direction == "LEFT")
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
					this.fire_direction = "RIGHT";				
					this.getShoot().moveRight();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
			}
			
			else if(this.fire_direction == "UP")
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
					this.fire_direction = "DOWN";					
					this.getShoot().moveDown();
					this.tableau[this.getShoot().getY()][this.getShoot().getX()] = 'F';
				}
			}
			
			else if(this.fire_direction == "DOWN")
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
					this.fire_direction = "UP";
					this.getShoot().moveUp();
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
			this.you_can_fire = 1;
		}
		
		if(this.getShoot().getX() == this.getMonster(this.monster).getX() && this.getShoot().getY() == this.getMonster(this.monster).getY())
		{
			this.tableau[this.getMonster(this.monster).getY()][this.getMonster(this.monster).getX()] = ' ';
			this.you_can_fire = 1;
			this.monster_death = 1;
			this.getMonster(this.monster).setX(0);
			this.getMonster(this.monster).setY(0);
			this.Score += 250;
		}
		
		if(this.getShoot().getX() == this.getMonster(this.monster2).getX() && this.getShoot().getY() == this.getMonster(this.monster2).getY())
		{
			this.tableau[this.getMonster(this.monster2).getY()][this.getMonster(this.monster2).getX()] = ' ';
			this.you_can_fire = 1;
			this.monster_death2 = 1;
			this.getMonster(this.monster2).setX(0);
			this.getMonster(this.monster2).setY(0);
			this.Score += 250;
		}
		
		if(this.getShoot().getX() == this.getMonster(this.monster3).getX() && this.getShoot().getY() == this.getMonster(this.monster3).getY())
		{
			this.tableau[this.getMonster(this.monster3).getY()][this.getMonster(this.monster3).getX()] = ' ';
			this.you_can_fire = 1;
			this.monster_death3 = 1;
			this.getMonster(this.monster3).setX(0);
			this.getMonster(this.monster3).setY(0);
			this.Score += 250;
		}
		
		if(this.getShoot().getX() == this.getMonster(this.monster4).getX() && this.getShoot().getY() == this.getMonster(this.monster4).getY())
		{
			this.tableau[this.getMonster(this.monster4).getY()][this.getMonster(this.monster4).getX()] = ' ';
			this.you_can_fire = 1;
			this.monster_death4 = 1;
			this.getMonster(this.monster4).setX(0);
			this.getMonster(this.monster4).setY(0);
			this.Score += 250;
		}
		
		if(this.getHero().getX() == this.energyX && this.getHero().getY() == this.energyY)
		{
			this.energyX = 0;
			this.energyY = 0;
			this.tableau[this.gateY][this.gateX] = 'C';
			this.gate_open = 1;
			this.Score += 50;
		}
		
		if(this.getHero().getX() == this.gateX && this.getHero().getY() == this.gateY)
		{
			if(this.gate_open == 0)
			{
				return true;
			}
			
			else
			{
				// WIN
				this.gateX = 0;
				this.gateY = 0;
				this.Score += 500;
			}
		}
		
		return false;
	}


}
