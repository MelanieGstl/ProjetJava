package element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

/**
 * The Class MonsterTest.
 * 
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 *
 */
public class MonsterTest {

	/** The monster */
	private Monster monster;

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
		this.monster = new Monster(10, 10);
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
		Assert.assertEquals(10, this.monster.getX());
	}
	
	/**
	 * Test SetX
	 */
	@Test
	public void testSetX(){
		final int expected = 3;
		this.monster.setX(3);
		Assert.assertEquals(expected, this.monster.getX());
	}
	
	/**
	 * Test GetY
	 */
	@Test
	public void testGetY(){
		Assert.assertEquals(10, this.monster.getY());
	}
	
	/**
	 * Test SetY
	 */
	@Test
	public void testSetY(){
		final int expected = 4;
		this.monster.setY(4);
		Assert.assertEquals(expected, this.monster.getY());
	}

	/**
	 * Test MoveUp
	 */
	@Test
	public void testMoveUp(){
		this.monster.moveUp();
		Assert.assertEquals(9, this.monster.getY());
	}
	
	/**
	 * Test MoveDown
	 */
	@Test
	public void testMoveDown(){
		this.monster.moveDown();
		Assert.assertEquals(11, this.monster.getY());
	}
	
	/**
	 * Test MoveLeft
	 */
	@Test
	public void testMoveLeft(){
		this.monster.moveLeft();
		Assert.assertEquals(9, this.monster.getX());
	}
	
	/**
	 * Test MoveRight
	 */
	@Test
	public void testMoveRight(){
		this.monster.moveRight();
		Assert.assertEquals(11, this.monster.getX());
	}
	
	/**
	 * Test SetDeath
	 */
	@Test
	public void testSetDeath(){
		final int expected = 2;
		this.monster.setDeath(2);
		Assert.assertEquals(expected, this.monster.getDeath());
	}
	
	/**
	 * Test GetDeath
	 */
	@Test
	public void testGetDeath(){
		Assert.assertEquals(1, this.monster.getDeath());
	}
}
