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
 * @author Groupe 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 */
public class DAOHelloWorld extends DAOEntity<HelloWorld> {

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
				helloWorld = new HelloWorld(resultSet.getInt("id"), key, resultSet.getString("message"));	
				/*String map = resultSet.getString("message");	
				Model model = new Model();
				model.loadMap(map);*/
			}
			
			return helloWorld;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
