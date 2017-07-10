package net.antra.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnitTest_2LifeCycle {
	@BeforeClass
	public static void beforeClass(){
		System.out.println("Before ALL test method is executed..");
	}
	@Before
	public void before(){
		System.out.println("Before each test method is executed..");
	}
	@Test
	public void testMethod(){
		assertTrue(100/2 == 50);
	}
	@Test
	public void testMethod2(){
		assertTrue(60/2 == 30);
	}
	@After
	public void after(){
		System.out.println("After each test method is executed..");
	}
	@AfterClass
	public static void afterClass(){
		System.out.println("After ALL test method is executed..");
	}
}
