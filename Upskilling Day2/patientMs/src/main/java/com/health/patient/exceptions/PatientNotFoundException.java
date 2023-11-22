package com.health.patient.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends Exception {

	public PatientNotFoundException(String message) {
		super(message);

	}
 
}