package model;

/**
 * The Class LoadHighscores.
 *
 * @author Groupe 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 */
public class LoadHighscore extends Entity {

///////////////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////////////

	/**
     * Instantiates a new LoadHighscore.
     *
     * @param name
     *          the name
     * @param score
     *          the scores
     */
    public LoadHighscore(String[] name, int[] score) {
        this.setName(name);
        this.setScore(score);
    }

    /**
     * Instantiates a new LoadHighscore.
     */
    public LoadHighscore() {
        
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/** The name. */
    private String[] name = new String[6];


    /** The scores. */
    private int[] score = new int[6];


/////////////////////////////////////////////////////////GETTERS//////////////////////////////////////////////////////////////
    
    /**
	 * Gets the name.
	 *
	 * @return name
	 * 			the name
	 */
    public String[] getName() {
        return name;
    }
    
    /**
	 * Gets the score.
	 *
	 * @return score
	 * 			the score
	 */
    public int[] getScore() {
        return score;
    }

/////////////////////////////////////////////////////////SETTERS//////////////////////////////////////////////////////////////

    /**
	 * Sets the name.
	 *
	 * @param name
	 * 			the name
	 */
    public void setName(String[] name) {
        this.name = name;
    }

    /**
	 * Sets the score.
	 *
	 * @param score
	 * 			the score
	 */
    public void setScore(int[] score) {
        this.score = score;
    }


}

