package com.health.patient.controller;

import java.util.List;
import java.util.Optional;

//import java.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.health.patient.exceptions.PatientNotFoundException;
import com.health.patient.controller.PatientController;
import com.health.patient.service.PatientServiceImp;
import com.health.patient.service.SequenceGeneratorService;
import com.health.patient.exceptions.NoProperDataException;
import com.health.patient.model.Patient;
import com.health.patient.repo.PatientRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class PatientController {
	Logger logger= LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientServiceImp patientServiceimpl;

	@Autowired
	private SequenceGeneratorService service;
	
	@Autowired
	private PatientRepo repository;
	
	@PostMapping("/addPatient")
	public ResponseEntity<?> addPatient( @RequestBody Patient patient)  throws NoProperDataException{
		if(patient!=null) 
		{
			
			patient.setId(service.getSequenceNumberForPatient(Patient.SEQUENCE_NAME));
			patientServiceimpl.addPatient(patient);
			logger.info("added patient");
			return new ResponseEntity<>(patient,HttpStatus.CREATED);
				
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
	}

	@GetMapping("/ListPatient")
	public ResponseEntity<List<Patient>> getAllPatient(String name) throws PatientNotFoundException  {
		//Patient patient=patientRepository.findAll();
		List<Patient> patients=patientServiceimpl.getAllPatient();
		logger.info("starting  of get mapping");
	
		if(patients.size()>0) {
			logger.info("patients are {}"+ patients);
		 return new  ResponseEntity<>(patients,HttpStatus.OK); 
		}
		else {
			logger.error(" no patients found ");
			 return new  ResponseEntity<>(patients,HttpStatus.NO_CONTENT); 
		}
	}


	@GetMapping("/ListPatient/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable int id )  throws PatientNotFoundException {
		Optional<Patient> patientdata= patientServiceimpl.findById(id);
		logger.info("starting  of get mapping");
		Patient patients=patientServiceimpl.getPatient(id);
	
		if(patients.getId()!=0) {
			logger.info("patients are {}"+ patients);
		 return new  ResponseEntity<>(patients,HttpStatus.OK); 
		}
		else {
			logger.error(" no patients found ");
			 return new  ResponseEntity<>(patients,HttpStatus.NOT_FOUND); 
		}
	}

	
	@DeleteMapping("/deletePatient/{id}")
	public ResponseEntity<HttpStatus> deletePatient(@PathVariable int id) throws PatientNotFoundException {
			//patientRepository.deleteById(id);
		try {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteAllPatients")
	public ResponseEntity<String> deleteAllPatients( ){
		try {
			patientServiceimpl.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e)
		{
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@PutMapping("/updatePatient/{id}")
	public ResponseEntity<Patient> updatePatient( @RequestBody Patient patient, @PathVariable int id) {
		Optional<Patient> patientdata= patientServiceimpl.findById(id);
		if(patientdata.isPresent())
		{
			Patient c= patientdata.get();
			c.setName(patient.getName());
			c.setAddress(patient.getAddress());
			c.setPhone(patient.getPhone());
			
			return new ResponseEntity<>(patientServiceimpl.save(c),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
