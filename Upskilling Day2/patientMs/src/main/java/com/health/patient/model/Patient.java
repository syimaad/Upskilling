package com.health.patient.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Patient")
public class Patient {
	
	public static final String SEQUENCE_NAME = "patient_sequence";
	@Id
	private int id;
	private String name;
	private String address;
	private long phone;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}


	
	public Patient() {
		super();
	}
	
	public Patient(int id, String name, String address, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
}
