package com.health.patient.service;

import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.health.patient.exceptions.PatientNotFoundException;
import com.health.patient.model.Patient;
import com.health.patient.repo.PatientRepo;
import com.health.patient.exceptions.NoProperDataException;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PatientServiceImp implements PatientService {
	Logger logger= LoggerFactory.getLogger(PatientServiceImp.class);
	
	@Autowired
	private PatientRepo patientRepository ;
	
	
	@Override
	public List<Patient> getAllPatient()  {
		logger.info("get all customers");
		return patientRepository.findAll();
}
	
	@Override
	public Patient addPatient(Patient patient) throws NoProperDataException {
		
		if(patient!=null) 
		{
			patientRepository.save(patient);
			logger.info("patient added {}",patient);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return patient;
	}
	

	
	@Override
	public Patient getPatient(int id) throws PatientNotFoundException {
		Patient patients=patientRepository.findById(id).orElseThrow(()-> new  PatientNotFoundException("patient Not Found"+id));
		logger.info("patients getbyid {}",patients);
		return patients;
	}

	



	@Override
	public String deletePatient(Integer id) throws PatientNotFoundException {
		logger.info("Start delete");
		var isRemoved =patientRepository.findById(id);
		if(isRemoved.isPresent())
		{
			patientRepository.deleteById(id);
			logger.info("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new PatientNotFoundException("Id Not Available");
		}
		logger.info(" deleted End");
		return " deleted successfully";
	}

public Patient save(@Validated Patient patient) {
		return patientRepository.save(patient);
	}

	
	public Optional<Patient> findByName(String name) {
		return patientRepository.findByName(name);
	}

	public Optional<Patient> findById(int id) {
		return patientRepository.findById(id);
	}

	public void deleteById(int id) {
		patientRepository.deleteById(id);
	}

	public void deleteAll() {
		patientRepository.deleteAll();
	}

	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	public Object getPatientById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object deletePatientById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object updatePatient(Patient p1) {
		// TODO Auto-generated method stub
		return null;
	}

	

}