package model;

/**
 * The Class LoadMap.
 *
 * @author Groupe 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 */
public class LoadMap extends Entity {

///////////////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////////////

	/**
     * Instantiates a new LoadMap.
     *
     * @param id
     *          the id
     * @param key
     *          the key
     * @param map
     *          the map 
     */
    public LoadMap(final int id, final String key, final String map) {
        this.setId(id);
        this.setKey(key);
        this.setMap(map);
    }

    /**
     * Instantiates a new Load Map.
     */
    public LoadMap() {
        this(0, "", "");
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/** The id. */
    private int			id;

    /** The key. */
    private String	key;

    /** The map. */
    private String	map;


/////////////////////////////////////////////////////////GETTERS//////////////////////////////////////////////////////////////

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Gets the key.
     *
     * @return the key
     */
    public String getKey() {
        return this.key;
    }
    
    /**
     * Gets the map.
     *
     * @return the map 
     */
    public String getMap() {
        return this.map;

    }

/////////////////////////////////////////////////////////SETTERS//////////////////////////////////////////////////////////////

    /**
    * Sets the id.
    *
    * @param id
    *          the new id
    */
   public void setId(final int id) {
       this.id = id;
   }

   /**
    * Sets the key.
    *
    * @param key
    *          the new key
    */
   public void setKey(final String key) {
       this.key = key;
   }

   /**
    * Sets the map.
    *
    * @param map
    *          the new map
    */
   public void setMap(final String map) {
       this.map = map;
   }
}

