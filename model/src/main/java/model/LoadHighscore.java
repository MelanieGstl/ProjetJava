package model;

/**
 * The Class LoadHighscores.
 *
 * @author Cedric Meyer
 */
public class LoadHighscore extends Entity {

    /** The name. */
    private String[] name = new String[6];


    /** The scores. */
    private int[] score = new int[6];

    /**
     * Instantiates a new hello world.
     *
     * @param name
     *          the nickname
     * @param score
     *          the scores
     */
    public LoadHighscore(String[] name, int[] score) {
        this.setName(name);
        this.setScore(score);
    }

    /**
     * Instantiates a new Load Map.
     */
    public LoadHighscore() {
        
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }
}

