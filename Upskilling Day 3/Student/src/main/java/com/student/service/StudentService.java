package com.student.service;

import com.student.model.Student;
import com.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepository;

	public List<Student> getAllStudents() {
     return studentRepository.findAll();
		}

	public Optional<Student> getStudentById(Integer id) {
     return studentRepository.findById(id);
		}

	public Student createStudent(Student student) {
     return studentRepository.save(student);
	}
	
	public Optional<Student> updateStudent(Integer id, Student updatedStudent) {
     if (studentRepository.existsById(id)) {
         updatedStudent.setId(id);
         return Optional.of(studentRepository.save(updatedStudent));
     } 
     else 
     {
         return Optional.empty();
     }
 }

	public boolean deleteStudent(Integer id) {
     if (studentRepository.existsById(id)) {
         studentRepository.deleteById(id);
         return true;
     } 
     else 
     {
         return false;
     }
 }
}

