package com.simplilearn.workshop;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedCasesTest {
	
	@Test
	void test() {
		System.out.println("outer class test");
	}
	
	@Nested
	class InnerClass {
		@Test
		void test() {
			System.out.println("inner class test");
		}
	}

}
