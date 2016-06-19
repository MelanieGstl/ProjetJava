package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


	/**
	 * The Class DAOLoadMap.
	 *
	 * @author Groupe 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
	 */
	class DAOScore extends DAOEntity<Score> {

	    /**
	     * Instantiates a new DAO Load Map.
	     *
	     * @param connection
	     *          the connection
	     * @throws SQLException
	     *           the SQL exception
	     */
	    public DAOScore(final Connection connection) throws SQLException {
	        super(connection);
	    }

	    /*
	     * (non-Javadoc)
	     *
	     * @see model.DAOEntity#create(model.Entity)
	     */
	    @Override
	    public boolean create(final Score entity) {
	        // Not implemented
	        return false;
	    }

	    /*
	     * (non-Javadoc)
	     *
	     * @see model.DAOEntity#delete(model.Entity)
	     */
	    @Override
	    public boolean delete(final Score entity) {
	        // Not implemented
	        return false;
	    }

	    /*
	     * (non-Javadoc)
	     *
	     * @see model.DAOEntity#update(model.Entity)
	     */
	    @Override
	    public boolean update(final Score entity) {
	        // Not implemented
	        return false;
	    }	
	
	    /*
	     * (non-Javadoc)
	     *
	     * @see model.DAOEntity#SaveScore(java.lang.String)
	     */
	public void SaveScore (final String name, int score) {
		
		try {
			final String sql = "{call Insert_score(?, ?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setString(1, name);
			call.setInt(2, score);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Score find(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#LoadHighscores(java.lang.String)
     */
	public LoadHighscore putHighscores() {
        LoadHighscore loadHighscore = new LoadHighscore();
        try {
            String[] name = new String[6];
            int[] score = new int[6];
            final String sql = "{call Take_Score()}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                for (int m = 0; m < 6; m++) {
                    name[m] = resultSet.getString("name");
                    score[m] = resultSet.getInt("score");
                    resultSet.next();
                }
                loadHighscore = new LoadHighscore(name, score);
            }

            return loadHighscore;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	
	
}
	


