package com.health.patient.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.health.patient.model.Patient;

public interface PatientRepo extends MongoRepository<Patient, Integer>{

	Optional<Patient> findByName(String name);
	
}
