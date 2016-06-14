package model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class DAOHelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
class DAOHelloWorld extends DAOEntity<HelloWorld> {

	/** Width */
	private int height = 1000;
	
	/** Height */
	private int width = 1000;
	
	private char[][] tableau = new char[this.getWidth()+1][this.getHeight()+1];

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOHelloWorld(final Connection connection) throws SQLException {
		super(connection);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#create(model.Entity)
	 */
	@Override
	public boolean create(final HelloWorld entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#delete(model.Entity)
	 */
	@Override
	public boolean delete(final HelloWorld entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#update(model.Entity)
	 */
	@Override
	public boolean update(final HelloWorld entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(java.lang.String)
	 */
	@Override
	public HelloWorld find(final String key) {
		HelloWorld helloWorld = new HelloWorld();

		try {
			final String sql = "{call Choose_Level(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setString(1, key);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				helloWorld = new HelloWorld(resultSet.getInt("id"), key, "Chargement de la map ...");	
				String map = resultSet.getString("message");	
				this.readFile(map);
			}
			
			return helloWorld;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public void readFile(String map)
	{		
		String[] tabmap = map.split("\n"); 
        for (int i =0; i < tabmap.length; i++)
        {
            for (int j = 0; j < tabmap[i].length(); j++)
            {
                switch (tabmap[i].charAt(j)){
                
                    case 'h':                       
                    	this.tableau[i][j] = 'h';
                        System.out.print(this.tableau[i][j]);
                   break;
                        
                    case 'b':                                           
                    	this.tableau[i][j] = 'b';
                        System.out.print(this.tableau[i][j]);
                    break;
                        
                    case 'v':                       
                    	this.tableau[i][j] = 'v';
                        System.out.print(this.tableau[i][j]);                  
                    break;
                    	
                    case 'p':                       
                    	this.tableau[i][j] = 'p';
                        System.out.print(this.tableau[i][j]);
                    break;
                        
                    case 'L':                       
                        //System.out.print(this.pngArray[i][j]);
                    break;
                    
                    case 'C':                       
                       // System.out.print(this.pngArray[i][j]);
                    break;
                    
                    case 'K':                       
                       // System.out.print(this.pngArray[i][j]);
                    break;
                    
                    default:
                    	this.tableau[i][j] = ' ';
                        System.out.print(this.tableau[i][j]);
                    break;
                }
            }
            System.out.println();
        }
		
		/* To show table
		for(y = 0; y < this.getHeight()+1; y++){
			for(x = 0; x < this.getWidth()+1; x++){				
				System.out.print(tableau[x][y]);
			}
		}*/
	}

}
