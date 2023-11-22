package com.student.Student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.student.model.Student;
import com.student.repo.StudentRepo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void testSaveStudent() {
        Student student = new Student();
        student.setName("Imaad");
        student.setAge(23);
        student.setSalary(28000.0);
        studentRepo.save(student);
    }

    @Test
    public void testFindStudentByName() {
        Student student = new Student();
        student.setName("Syed");
        student.setAge(25);
        student.setSalary(30000.0);
        studentRepo.save(student);

        Student foundStudent = studentRepo.findByName("Syed");
        assertNotNull(foundStudent);
        assertEquals("Syed", foundStudent.getName());
    }
}
