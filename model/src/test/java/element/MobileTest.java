package element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MobileTest {

	private Mobile mobile;

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
		this.mobile = new Mobile();
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
	public void testGetY(){
		Assert.assertEquals(0, this.mobile.getY());
	}
	
	@Test
	public void testSetY(){
		final int expected = 3;
		this.mobile.setY(3);
		Assert.assertEquals(expected, this.mobile.getY());
	}
	
	@Test
	public void testMoveUp(){
		this.mobile.setY(4);
		this.mobile.moveUp(4);
		Assert.assertEquals(3, this.mobile.getY());
	}

}
