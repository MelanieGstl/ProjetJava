package element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class ShootTest {

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
	
	@Test
	public void testGetX(){
		Assert.assertEquals(10, this.shoot.getX());
	}
	
	@Test
	public void testSetX(){
		final int expected = 3;
		this.shoot.setX(3);
		Assert.assertEquals(expected, this.shoot.getX());
	}
	
	@Test
	public void testGetY(){
		Assert.assertEquals(10, this.shoot.getY());
	}
	
	@Test
	public void testSetY(){
		final int expected = 4;
		this.shoot.setY(4);
		Assert.assertEquals(expected, this.shoot.getY());
	}

	@Test
	public void testMoveUp(){
		this.shoot.moveUp();
		Assert.assertEquals(9, this.shoot.getY());
	}
	
	@Test
	public void testMoveDown(){
		this.shoot.moveDown();
		Assert.assertEquals(11, this.shoot.getY());
	}
	
	@Test
	public void testMoveLeft(){
		this.shoot.moveLeft();
		Assert.assertEquals(9, this.shoot.getX());
	}
	
	@Test
	public void testMoveRight(){
		this.shoot.moveRight();
		Assert.assertEquals(11, this.shoot.getX());
	}
	
	@Test
	public void testMoveDiagoHD(){
		this.shoot.moveDiagoHD();
		Assert.assertEquals(9, this.shoot.getY());
		Assert.assertEquals(11, this.shoot.getX());
	}
	
	@Test
	public void testMoveDaigoHG(){
		this.shoot.moveDiagoHG();
		Assert.assertEquals(9, this.shoot.getY());
		Assert.assertEquals(9, this.shoot.getX());
	}
	
	@Test
	public void testMoveDiagoBD(){
		this.shoot.moveDiagoBD();
		Assert.assertEquals(11, this.shoot.getX());
		Assert.assertEquals(11, this.shoot.getY());
	}
	
	@Test
	public void testMoveDiagoBG(){
		this.shoot.moveDiagoBG();
		Assert.assertEquals(9, this.shoot.getX());
		Assert.assertEquals(11, this.shoot.getY());
	}
	
	@Test
	public void testGetFireDirection(){
		Assert.assertEquals("RIGHT", this.shoot.getFireDirection());
	}
}
