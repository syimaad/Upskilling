package com.health.patient.service;


import java.util.List;

import com.health.patient.exceptions.PatientNotFoundException;
import com.health.patient.model.Patient;
import com.health.patient.exceptions.NoProperDataException;

public interface PatientService {

	List<Patient> getAllPatient() throws PatientNotFoundException;

	Patient addPatient(Patient patient) throws NoProperDataException;


	String deletePatient(Integer id) throws PatientNotFoundException;

	Patient getPatient(int id) throws PatientNotFoundException;

}
