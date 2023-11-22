package com.student.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.student.model.Student;

public interface StudentRepo extends MongoRepository<Student, Integer>{

	Student findByName(String name);

//	void save(Student student);
	
}