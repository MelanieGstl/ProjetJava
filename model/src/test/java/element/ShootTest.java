package element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

/**
 * The Class ShootTest.
 * 
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 *
 */
public class ShootTest {

	/** The shoot */
	private Shoot shoot;

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
		this.shoot = new Shoot(10, 10);
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
		Assert.assertEquals(10, this.shoot.getX());
	}
	
	/**
	 * Test SetX
	 */
	@Test
	public void testSetX(){
		final int expected = 3;
		this.shoot.setX(3);
		Assert.assertEquals(expected, this.shoot.getX());
	}
	
	/**
	 * Test GetY
	 */
	@Test
	public void testGetY(){
		Assert.assertEquals(10, this.shoot.getY());
	}
	
	/**
	 * Test SetY
	 */
	@Test
	public void testSetY(){
		final int expected = 4;
		this.shoot.setY(4);
		Assert.assertEquals(expected, this.shoot.getY());
	}

	/**
	 * Test MoveUp
	 */
	@Test
	public void testMoveUp(){
		this.shoot.moveUp();
		Assert.assertEquals(9, this.shoot.getY());
	}
	
	/**
	 * Test MoveDown
	 */
	@Test
	public void testMoveDown(){
		this.shoot.moveDown();
		Assert.assertEquals(11, this.shoot.getY());
	}
	
	/**
	 * Test MoveLeft
	 */
	@Test
	public void testMoveLeft(){
		this.shoot.moveLeft();
		Assert.assertEquals(9, this.shoot.getX());
	}
	
	/**
	 * Test MoveRight
	 */
	@Test
	public void testMoveRight(){
		this.shoot.moveRight();
		Assert.assertEquals(11, this.shoot.getX());
	}
	
	/**
	 * Test MoveDiagoHD
	 */
	@Test
	public void testMoveDiagoHD(){
		this.shoot.moveDiagoHD();
		Assert.assertEquals(9, this.shoot.getY());
		Assert.assertEquals(11, this.shoot.getX());
	}
	
	/**
	 * Test MoveDiagoHG
	 */
	@Test
	public void testMoveDaigoHG(){
		this.shoot.moveDiagoHG();
		Assert.assertEquals(9, this.shoot.getY());
		Assert.assertEquals(9, this.shoot.getX());
	}
	
	/**
	 * Test MoveDiagoBD
	 */
	@Test
	public void testMoveDiagoBD(){
		this.shoot.moveDiagoBD();
		Assert.assertEquals(11, this.shoot.getX());
		Assert.assertEquals(11, this.shoot.getY());
	}
	
	/**
	 * Test MoveDiagoBG
	 */
	@Test
	public void testMoveDiagoBG(){
		this.shoot.moveDiagoBG();
		Assert.assertEquals(9, this.shoot.getX());
		Assert.assertEquals(11, this.shoot.getY());
	}
	
	/**
	 * Test GetFireDirection
	 */
	@Test
	public void testGetFireDirection(){
		Assert.assertEquals("RIGHT", this.shoot.getFireDirection());
	}
}
