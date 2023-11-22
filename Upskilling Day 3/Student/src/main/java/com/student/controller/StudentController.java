package com.student.controller;

import com.student.model.Student;
import com.student.controller.StudentController;
import com.student.service.StudentService;
import com.student.service.StudentServiceImp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
	Logger logger= LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;
    @Autowired
	private StudentServiceImp studentServiceimpl;
    
    @GetMapping("/listStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
    	logger.info("starting  of get mapping");
        List<Student> students = studentService.getAllStudents();
        if(students.size()>0) {
			logger.info("students are {}"+ students);
		 return new  ResponseEntity<>(students,HttpStatus.OK); 
		}
		else {
			logger.error(" no students found ");
			 return new  ResponseEntity<>(students,HttpStatus.NO_CONTENT); 
		}
    }

    @GetMapping("/listStudent/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
    	logger.info("starting  of get mapping");
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        logger.info("added student");
        return ResponseEntity.ok(createdStudent);
    }

    @PutMapping("editStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
        Optional<Student> student = studentService.updateStudent(id, updatedStudent);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        if (studentService.deleteStudent(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
