package com.student.model;

import java.util.Optional;

public class Student {
	
	public static final String SEQUENCE_NAME = null;
	private String name;
	private int age;
	private double salary;
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double d) {
		this.salary = d;
	}

	
	public Student() {
		super();
	}
	public Student(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public Optional<Student> map(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
