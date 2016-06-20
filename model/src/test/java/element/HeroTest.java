package element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

/**
 * The Class HeroTest.
 * 
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 *
 */
public class HeroTest {

	/** The hero */
	private Hero hero;

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
		this.hero = new Hero(10, 10);
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
	
	/**
	 * Test GetX
	 */
	@Test
	public void testGetX(){
		Assert.assertEquals(10, this.hero.getX());
	}
	
	/**
	 * Test SetX
	 */
	@Test
	public void testSetX(){
		final int expected = 3;
		this.hero.setX(3);
		Assert.assertEquals(expected, this.hero.getX());
	}
	
	/**
	 * Test GetY
	 */
	@Test
	public void testGetY(){
		Assert.assertEquals(10, this.hero.getY());
	}
	
	/**
	 * Test SetY
	 */
	@Test
	public void testSetY(){
		final int expected = 4;
		this.hero.setY(4);
		Assert.assertEquals(expected, this.hero.getY());
	}

	/**
	 * Test MoveUp
	 */
	@Test
	public void testMoveUp(){
		this.hero.moveUp();
		Assert.assertEquals(9, this.hero.getY());
	}
	
	/**
	 * Test MoveDown
	 */
	@Test
	public void testMoveDown(){
		this.hero.moveDown();
		Assert.assertEquals(11, this.hero.getY());
	}
	
	/**
	 * Test MoveLeft
	 */
	@Test
	public void testMoveLeft(){
		this.hero.moveLeft();
		Assert.assertEquals(9, this.hero.getX());
	}
	
	/**
	 * Test MoveRight
	 */
	@Test
	public void testMoveRight(){
		this.hero.moveRight();
		Assert.assertEquals(11, this.hero.getX());
	}
	
}
