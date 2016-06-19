package element;

/**
 * The Class ElementLevel.
 * 
 * @author Groupe 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 *
 */

public class ElementLevel {

	
	/** Horizontal place of the energy ball */
	public int energyX = 25;
	
	/** Vertical place of the energy ball */
	public int energyY = 25;
	
	/** Horizontal place of the gate */
	public int gateX = 25;
	
	/** Vertical place of the gate */
	public int gateY = 25;
	
	/** Indicator if the gate is open are close */
	public int gate_open = 0;
	
	/** Indicator if the the hero can shoot his fireball */
	public int you_can_fire = 1;	
	
	/** The last key which were pressed */
	private String lastKey = "RIGHT";	
	
	/** The score */
	public int Score;
	
	/////////////////////////////////////
	public int loadMap;


/////////////////////////////////////////////////////////GETTERS//////////////////////////////////////////////////////////////

	/** 
     * Gets the horizontal place of the energy ball
     *   
     *   @return energyX
     *   			Horizontal place of the energy ball
     */
	public int getEnergyX()
	{
		return this.energyX;
	}
	
	/** 
     * Gets the vertical place of the energy ball
     *   
     *   @return energyY
     *   			Vertical place of the energy ball
     */
	public int getEnergyY()
	{
		return this.energyY;
	}
	
	/** 
     * Gets the horizontal place of the gate
     *   
     *   @return gateX
     *   			Horizontal place of the gate
     */
	public int getGateX()
	{
		return this.gateX;
	}
	
	/** 
     * Gets the vertical place of the gate
     *   
     *   @return gateY
     *   			Vertical place of the gate
     */
	public int getGateY()
	{
		return this.gateY;
	}
	
	/** 
     * Gets if the gate is open or close
     *   
     *   @return gate_open
     *   			Indicator if the gate is open are close
     */
	public int getGateOpen()
	{
		return this.gate_open;
	}
	
	/** 
     * Gets if the hero can shoot a fireball
     *   
     *   @return you_can_fire
     *   			Indicator if the the hero can shoot his fireball
     */
	public int getFire()
	{
		return this.you_can_fire;
	}
	
	/** 
     * Gets the last key which were pressed by the player
     *   
     *   @return lastKey
     *   			The last key which were pressed
     */
	public String getLastKey()
	{
		return this.lastKey;
	}
	
	/** 
     * Gets the score of the player
     *   
     *   @return score
     *   			the score
     */
	public int getScore()
	{
		return this.Score;
	}
	
	/////////////////////////////////////
	public int getLoadMap()
	{
		return this.loadMap;
	}

/////////////////////////////////////////////////////////SETTERS//////////////////////////////////////////////////////////////
	/** 
     * Set the horizontal place of the energy ball
     *   
     *   @param energyX
     *   			Horizontal place of the energy ball
     */
	public void setEnergyX(int x)
	{
		this.energyX = x;
	}
	
	/** 
     * Set the vertical place of the energy ball
     *   
     *   @param energyY
     *   			Vertical place of the energy ball
     */
	public void setEnergyY(int y)
	{
		this.energyY = y;
	}
	
	/** 
     * Set the horizontal place of the gate
     *   
     *   @param gateX
     *   			Horizontal place of the gate
     */
	public void setGateX(int x)
	{
		this.gateX = x;
	}
	
	/** 
     * Set the vertical place of the gate
     *   
     *   @param gateY
     *   			Vertical place of the gate
     */
	public void setGateY(int y)
	{
		this.gateY = y;
	}
	
	/** 
     * Set the gate to open or close
     *   
     *   @param gate_open
     *   			Indicator if the gate is open are close
     */
	public void setGateOpen(int gate_open)
	{
		this.gate_open = gate_open;
	}
	
	/** 
     * Set if the hero can shoot a fireball
     *   
     *   @param you_can_fire
     *   			Indicator if the the hero can shoot his fireball
     */
	public void setFire(int fire)
	{
		this.you_can_fire = fire;
	}
	
	/** 
     * Set the last key which were pressed by the player
     *   
     *   @param lastKey
     *   			The last key which were pressed
     */
	public void setLastKey(String lastKey)
	{
		this.lastKey = lastKey;
	}

	/** 
     * Set the score of the player
     *   
     *   @param score
     *   			the score
     */
	public void setScore(int score)
	{
		this.Score = score;
	}
	
	
	//////////////////////////////////////////////////////////////////
	public void setLoadMap(int loadMap)
	{
		this.loadMap = loadMap;
	}
}
