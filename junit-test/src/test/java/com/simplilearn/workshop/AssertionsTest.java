package com.simplilearn.workshop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Assertions")
public class AssertionsTest {
	
	@Test
	public void assertTestTrue() {
		assertTrue(4>0);
	}
	
	@Test
	public void assertTestFalse() {
		assertFalse(5 < 1);
	}
	
	@Test
	public void assertTestNull() {
		String s1 = null;
		assertNull(s1);
	}
	
	@Test
	public void assertTestNotNull() {
		String s1 = "not null";
		assertNotNull(s1);
	}

	@Test
	public void assertTestSame() {
		String s1 = "not null"; //would fail if not the same.
		String s2 = "not null";
		assertSame(s1,s2);
	}
	
	@Test
	public void assertTestNotSame() {
		String s1 = null;
		String s2 = "not null";
		assertNotSame(s1,s2);
	}
	
	@Test
	public void assertTestEquals() {
		
		assertEquals(5,5);
	}
	
	@Test
	public void assertTestNotEquals() {
		assertNotEquals(5,6);
	}
	
	@Test
	public void assertTestArray() {
		String[] a1 = {"A","B"};
		String[] a2 = {"A","B"};
		
		assertArrayEquals(a1,a2);
	}
	
	@Test
	public void assertTestThrows() {
			
		assertThrows(RuntimeException.class,()-> {throw new RuntimeException(); });
	}
	
}
