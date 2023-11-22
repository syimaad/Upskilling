package com.student.Student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.student.model.Student;

class StudentTest {

	Student s1;
	@BeforeEach
	public void before() {
		s1=new Student("Imaad",23 ,9720);
	}
	
	
	@AfterEach
	public void after() {
		s1=null;
	}
	
	@Test
	void testGetId() {
		assertEquals(101, s1.getId());
	}

	@Test
	void testGetAge() {
		assertEquals(23, s1.getAge());
	}

	@Test
	void testGetName() {
		assertEquals("Joy", s1.getName());
	}

	@Test
	void testGetSalary() {
		assertEquals(9720, s1.getSalary());
	}

	@Test
	void testSetId() {
		s1.setId(111);
		//assertEquals(101, s1.getId());
	}

	@Test
	void testSetAge() {
		s1.setAge(23);
		assertEquals(23, s1.getAge());
	}

	@Test
	void testSetName() {
		s1.setName("Tara");
		assertEquals("Tara", s1.getName());
	}

	@Test
	void testSetSalary() {
		s1.setSalary(974200);
		assertEquals(974200, s1.getSalary());
	}
	
}

