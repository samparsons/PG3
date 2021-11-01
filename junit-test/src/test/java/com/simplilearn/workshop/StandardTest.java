package com.simplilearn.workshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

@TestInstance(Lifecycle.PER_CLASS)
public class StandardTest {
	
	@BeforeAll
	static void initAll() {
		System.out.println("execute before the tests run");
	}
	
	@BeforeEach
	void init() {
		System.out.println("execute before each test method");
	}
	
	@Test
	@Disabled
	void failingTest() {
		fail("this method always fails");
	}
	
	@Test
	void succedingTest1() {
		System.out.println("always pass 1");
	}
	
	@Test
	void succedingTest2() {
		System.out.println("always pass 2");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("after each method is invoked");
	}
	
	@AfterAll
	void tearDownAll() {
		System.out.println("after all methods have ran");
	}
	
}
