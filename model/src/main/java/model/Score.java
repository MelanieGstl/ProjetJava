package model;

/**
 * The Class LoadMap.
 *
 * @author 
 */
public class Score extends Entity{
	/** The score. */
    private int	score;

    /** The name. */
    private String	name;



    /**
     * Instantiates a new hello world.
     *
     * @param id
     *          the id
     * @param key
     *          the key
     * @param map
     *          the map content
     */
    public Score(final String name, final int score) {
        this.setName(name);
        this.setScore(score);
    }

    /**
     * Instantiates a new Load Map.
     */
    public Score() {
        this("", 0);
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Sets the id.
     *
     * @param id
     *          the new id
     */
    public void setScore(final int score) {
        this.score = score;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the key.
     *
     * @param key
     *          the new key
     */
    public void setName(final String name) {
        this.name = name;
    }

}