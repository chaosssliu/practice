package net.antra.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTest_1Basic {
	@Test
	public void testTrue(){
		assertTrue(1==1);
	}
	
	@Test
	public void testFalse(){
		assertFalse(2==1);
		System.out.println("2==1 case");
	}
	
	@Test
	public void testEquals(){
		assertEquals("A","A");
		System.out.println("A case");
	}
}
