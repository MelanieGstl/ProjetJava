/**
 *
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class ModelTest.
 *
 * @author Jean-Aymeric Diet
 */
public class ModelTest {
	private Model model;

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
		this.model = new Model();
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
	 * Test method for {@link model.Model#getMessage()}.
	 */
	@Test
	public void testGetMessage() {
		Assert.assertEquals("", this.model.getMessage());
	}

	/**
	 * Test method for {@link model.Model#loadMessage(java.lang.String)}.
	 */
	@Test
	public void testGetMessageString() {
		this.model.loadMessage("ONE");
		Assert.assertEquals("bhhhhhhhhhhhhhhhhhhb\nv 1                v\nv           e      v\nv                  v\nvhhhhhhb           v\nv      p           v\nv      v           v\nv      v           v\nvhhhhhhb           v\nv           l      v\nv                  v\nvhhhhhhhhhhhb      v\nv c                v\nv                  v\nbhhhhhhhhhhhhhhhhhhb", this.model.getMessage());
		this.model.loadMessage("TWO");
		Assert.assertEquals("bhhhhhhhhhhhhhhhhhhb\nvl                 v\nv  bhhhhb   bhhhb  v\nv  v            v  v\nv  v            v  v\nv  v  p         v  v\nv  v            v  v\nv  v        e   v 2v\nv  v            v  v\nv  v            v  v\nv  v            v  v\nv  v            v  v\nv  bhhhhhhhhhhhhb  v\nv  1               v\nbhhhhhhhhhhhhhhhhhhb", this.model.getMessage());
		this.model.loadMessage("THREE");
		Assert.assertEquals("bhhhhhhhhhhhhhhhhhhb\nv 1   p            v\nvhhhhhhhhhhhhb     v\nv e v              v\nv   v     v        v\nv 2       v        v\nvhhhhhhhhhhhhb     v\nv                  v\nv                3 v\nv   bhhhhhhhhhhhhhhv\nv                  v\nvhhhhhhhhhhhhb     v\nv                  v\nv clb              v\nbhhhhhhhhhhhhhhhhhhb", this.model.getMessage());
		this.model.loadMessage("FOUR");
		Assert.assertEquals("bhhhhhhhhhhhhhhhhhhb\nv  1               v\nvbb    b b    hhhhhv\nv     b    b       v\nv     b p  b     2 v\nv     b   b        v\nv     b   b        v\nv 3    bbb       e v\nv           hhhhhhhv\nv   b              v\nv   v    b         v\nv   v    v         v\nv   v    v         v\nv   v l  v   4   c v\nbhhhhhhhhhhhhhhhhhhb", this.model.getMessage());
		this.model.loadMessage("FIVE");
		Assert.assertEquals("bhhhhhhhhhhhhhhhhhhb\nv                 lv\nvhhhhb bhhhhhhhhhhhv\nv            4     v\nvhhhhhhhhhhhhhhhhb v\nv   3              v\nv bhhhhhhhhhhhhhhhhv\nv                  v\nvhhhhhhhhhhhhb bhhhv\nv            2     v\nvhb bhhhhhhhhhhhhhhv\nv                  v\nvhhhhhhhhb bhhhhhhhv\nvc p         1   e v\nbhhhhhhhhhhhhhhhhhhb", this.model.getMessage());
	}
	
	
	
	@Test
	public void testIsMovePossible(){
		Assert.assertEquals(true, this.model.isMovePossible(0, 0));
	}
	
	@Test
	public void testMoveUp(){
		Assert.assertEquals(0, this.model.getElement(2, 3));
	}
	
	@Test
	public void testMoveLeft(){
		Assert.assertEquals(0, this.model.getElement(5, 9));
	}
	
	@Test
	public void testMoveRight(){
		Assert.assertEquals(0, this.model.getElement(10, 2));
	}
	
	@Test
	public void testMoveDown(){
		Assert.assertEquals(0, this.model.getElement(12, 16));
	}
	
	@Test
	public void testGetWidth(){
		Assert.assertEquals(20, this.model.getWidth());
	}
	
	@Test
	public void testGetHeight(){
		Assert.assertEquals(20, this.model.getHeight());
	}
	
	@Test
	public void testGetMap(){
		char[][] map = new char[21][21];
		Assert.assertEquals(map, this.model.getMap());
	}
	
	@Test
	public void testGetElement(){
		Assert.assertEquals(0, this.model.getElement(5, 6));
	}
	
	@Test
	public void testGetLastKey(){
		Assert.assertEquals("right", this.model.getLastMove());
	}
	
	@Test
	public void testSetLastMove(){
		final String expected = "left";
		this.model.setLastMove("left");
		Assert.assertEquals(expected, this.model.getLastMove());
	}
	

}
