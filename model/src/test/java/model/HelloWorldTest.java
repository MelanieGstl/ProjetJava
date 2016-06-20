package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

/**
 * The HelloWorld Test class.
 * 
 * @author Group 1 : Mélanie GSTALTER, Hugo HUILIER, Julie MEYER
 *
 */
public class HelloWorldTest {
	
	/** Helloworld */
	private HelloWorld hello;

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
		this.hello= new HelloWorld();
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
	 * Test GetId
	 */
	@Test
	public void testGetId(){
		Assert.assertEquals(0, this.hello.getId());
	}
	
	/**
	 * Test SetId
	 */
	@Test
	public void testSetId(){
		final int expected = 2;
		this.hello.setId(2);
		Assert.assertEquals(expected, this.hello.getId());
	}
	
	/**
	 * Test GetKey
	 */
	@Test
	public void testGetKey(){
		Assert.assertEquals("", this.hello.getKey());
	}
	
	/**
	 * Test SetKey
	 */
	@Test
	public void testSetKey(){
		final String expected = "hello";
		this.hello.setKey("hello");
		Assert.assertEquals(expected, this.hello.getKey());
	}
	
	/**
	 * Test GetMessage
	 */
	@Test
	public void testGetMessage(){
		Assert.assertEquals("", this.hello.getMessage());
	}
	
	/**
	 * Test SetMessage
	 */
	@Test
	public void testSetMessage(){
		final String expected = "hello";
		this.hello.setMessage("hello");
		Assert.assertEquals(expected, this.hello.getMessage());
	}
	
	


}
