package com.in28minutes.junit.helper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;

public class QuickBeforeAfterTest {
	
	@BeforeTestClass
	public static void beforeClass(){
		System.out.println("Before Class");
	}
	
	@BeforeAll
	public void setup(){
		System.out.println("Before Test");
	}

	@Test
	public void test1() {
		System.out.println("test1 executed");
	}

	@Test
	public void test2() {
		System.out.println("test2 executed");
	}
	
	@AfterAll
	public void teardown() {
		System.out.println("After test");
	}
	
	@AfterTestClass
	public static void afterClass(){
		System.out.println("After Class");
	}

}