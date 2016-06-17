package element;

public class ElementLevel {
	public int energyX = 25;
	public int energyY = 25;
	public int gateX = 25;
	public int gateY = 25;
	public int gate_open = 0;
	public int you_can_fire = 1;	
	private String lastKey = "RIGHT";	
	public int Score;
	public int loadMap;
	
	public int getEnergyX()
	{
		return this.energyX;
	}
	
	public void setEnergyX(int x)
	{
		this.energyX = x;
	}
	
	public int getEnergyY()
	{
		return this.energyY;
	}
	
	public void setEnergyY(int y)
	{
		this.energyY = y;
	}
	
	public int getGateX()
	{
		return this.gateX;
	}
	
	public void setGateX(int x)
	{
		this.gateX = x;
	}
	
	public int getGateY()
	{
		return this.gateY;
	}
	
	public void setGateY(int y)
	{
		this.gateY = y;
	}
	
	public int getGateOpen()
	{
		return this.gate_open;
	}
	
	public void setGateOpen(int gate_open)
	{
		this.gate_open = gate_open;
	}
	
	public int getFire()
	{
		return this.you_can_fire;
	}
	
	public void setFire(int fire)
	{
		this.you_can_fire = fire;
	}
	
	public String getLastKey()
	{
		return this.lastKey;
	}
	
	public void setLastKey(String lastKey)
	{
		this.lastKey = lastKey;
	}
	
	public int getScore()
	{
		return this.Score;
	}
	
	public void setScore(int score)
	{
		this.Score = score;
	}
	
	public int getLoadMap()
	{
		return this.loadMap;
	}
	
	public void setLoadMap(int loadMap)
	{
		this.loadMap = loadMap;
	}
}
