package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import element.Hero;
import junit.framework.Assert;

public class ScoreTest {

	private Score score;

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
		this.score = new Score();
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
	public void testGetScore(){
		Assert.assertEquals(0, this.score.getScore());
	}
	
	@Test
	public void testSetScore(){
		final int expected = 3;
		this.score.setScore(3);
		Assert.assertEquals(expected, this.score.getScore());
	}
	
	@Test
	public void testGetName(){
		Assert.assertEquals("", this.score.getName());
	}
	
	@Test
	public void testSetName(){
		final String expected = "julie";
		this.score.setName("julie");
		Assert.assertEquals(expected, this.score.getName());
	}
}
