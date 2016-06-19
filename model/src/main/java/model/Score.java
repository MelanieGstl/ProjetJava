package model;

/**
 * The Class Score.
 *
 * @author Groupe 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 */
public class Score extends Entity{
	
///////////////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////////////

	/**
     * Instantiates a new score.
     *
     * @param name
     *          the name
     * @param score
     *          the score
     * 
     */
    public Score(final String name, final int score) {
        this.setName(name);
        this.setScore(score);
    }

    /**
     * Instantiates a new score.
     */
    public Score() {
        this("", 0);
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/** The score. */
    private int	score;

    /** The name. */
    private String	name;


/////////////////////////////////////////////////////////GETTERS//////////////////////////////////////////////////////////////

    /**
     * Gets the score.
     *
     * @return score
     * 			the score
     */
    public int getScore() {
        return this.score;
    }
    
    /**
     * Gets the name.
     *
     * @return name
     * 			the name
     */
    public String getName() {
        return this.name;
    }

/////////////////////////////////////////////////////////SETTERS//////////////////////////////////////////////////////////////

    /**
     * Sets the score.
     *
     * @param score
     *          the new score
     */
    public void setScore(final int score) {
        this.score = score;
    }

    /**
     * Sets the name.
     *
     * @param name
     *          the new name
     */
    public void setName(final String name) {
        this.name = name;
    }

}