package com.JPA.Demo.repository;

import com.JPA.Demo.entity.Guardian;
import com.JPA.Demo.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//@DataJpaTest
//datajpatest test repo and then flush the data
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @BeforeEach
    void setUp() {
    }
//    @Test
//    public void saveStudent() {
//        Student student = Student.builder()
//                .emailId("muthu@12345")
//                .firstName("Muthu")
//                .lastName("M")
////                .guardianName("King")
////                .guardianEmail("king@123")
////                .guardianMobile("9361422243")
//                .build();
//        studentRepository.save(student);
//    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Raju")
                .email("Raj@gmail.com")
                .mobile("9999988888")
                .build();

        Student student = Student.builder()
                .firstName("Mass")
                .lastName("M")
                .emailId("masss@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void findAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }



}