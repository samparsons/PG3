package com.simplilearn.workshop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@DisplayName("Conditionals")
public class ConditionalTest {
	
	@Test
	@EnabledOnOs({OS.WINDOWS})
	public void executeOnWindows() {
		System.out.println("method executed on windows os only");
	}
	
	@Test
	@EnabledOnOs({OS.LINUX})
	public void executeOnLinux() {
		System.out.println("method executed on linux os only");
	}
	
	@Test
	@EnabledOnOs({OS.MAC})
	public void executeOnMac() {
		System.out.println("method executed on mac os only");
	}
}
