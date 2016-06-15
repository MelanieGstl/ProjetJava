package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class LoadMapTest {
	private LoadMap load;

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
		this.load= new LoadMap();
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
	public void testGetId(){
		Assert.assertEquals(0, this.load.getId());
	}
	
	@Test
	public void testSetId(){
		final int expected = 2;
		this.load.setId(2);
		Assert.assertEquals(expected, this.load.getId());
	}
	
	@Test
	public void testGetKey(){
		Assert.assertEquals("", this.load.getKey());
	}
	
	@Test
	public void testSetKey(){
		final String expected = "hello";
		this.load.setKey("hello");
		Assert.assertEquals(expected, this.load.getKey());
	}
	
	@Test
	public void testGetMap(){
		Assert.assertEquals("", this.load.getMap());
	}
	
	@Test
	public void testSetMap(){
		final String expected = "hello";
		this.load.setMap("hello");
		Assert.assertEquals(expected, this.load.getMap());
	}
	
	

}
