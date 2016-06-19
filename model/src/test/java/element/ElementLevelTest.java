package element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class ElementLevelTest {

	private ElementLevel level;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.level = new ElementLevel();
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetEnergyX(){
		Assert.assertEquals(25, this.level.getEnergyX());
	}
	
	@Test
	public void testSetEnergyX(){
		final int expected = 10;
		this.level.setEnergyX(10);
		Assert.assertEquals(expected, this.level.getEnergyX());
	}
	
	@Test
	public void testGetEnergyY(){
		Assert.assertEquals(25, this.level.getEnergyY());
	}
	
	@Test
	public void testSetEnergyY(){
		final int expected = 10;
		this.level.setEnergyY(10);
		Assert.assertEquals(expected, this.level.getEnergyY());
	}
	
	@Test
	public void testGetGateX(){
		Assert.assertEquals(25, this.level.getGateX());
	}
	
	@Test
	public void testSetGateX(){
		final int expected = 10;
		this.level.setGateX(10);
		Assert.assertEquals(expected, this.level.getGateX());
	}
	
	@Test
	public void testGetGateY(){
		Assert.assertEquals(25, this.level.getGateY());
	}
	
	@Test
	public void testSetGateY(){
		final int expected = 10;
		this.level.setGateY(10);
		Assert.assertEquals(expected, this.level.getGateY());
	}
	
	@Test
	public void testGetGateOpen(){
		Assert.assertEquals(0, this.level.getGateOpen());
	}
	
	@Test
	public void testSetGateOpen(){
		final int expected = 10;
		this.level.setGateOpen(10);
		Assert.assertEquals(expected, this.level.getGateOpen());
	}
	
	@Test
	public void testGetFire(){
		Assert.assertEquals(1, this.level.getFire());
	}
	
	@Test
	public void testSetFire(){
		final int expected = 10;
		this.level.setFire(10);
		Assert.assertEquals(expected, this.level.getFire());
	}
	
	@Test
	public void testGetLastKey(){
		Assert.assertEquals("RIGHT", this.level.getLastKey());
	}
	
	@Test
	public void testSetLastKey(){
		final String expected = "left";
		this.level.setLastKey("left");
		Assert.assertEquals(expected, this.level.getLastKey());
	}
	
	@Test
	public void testGteScore(){
		Assert.assertEquals(0, this.level.getScore());
	}
	
	@Test
	public void testSetScore(){
		final int expected = 10;
		this.level.setScore(10);
		Assert.assertEquals(expected, this.level.getScore());
	}
	
	@Test
	public void testGetLoadMap(){
		Assert.assertEquals(0, this.level.getLoadMap());
	}
	
	@Test
	public void testSetLoadMap(){
		final int expected = 10;
		this.level.setLoadMap(10);
		Assert.assertEquals(expected, this.level.getLoadMap());
	}


}
