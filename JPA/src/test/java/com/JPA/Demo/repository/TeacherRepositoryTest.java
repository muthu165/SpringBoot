package com.JPA.Demo.repository;

import com.JPA.Demo.entity.Course;
import com.JPA.Demo.entity.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    TeacherRepository teacherRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void saveTeacher() {
        Course courseOs = Course.builder()
                .title("React")
                .credit(10)
                .build();
        Course courseJava = Course.builder()
                .title("Python")
                .credit(10)
                .build();
//        Course courseC = Course.builder()
//                .title("C++")
//                .credit(10)
//                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Mark")
                .lastName("Son")
//                .courses(List.of(courseOs, courseJava))
                .build();
        teacherRepository.save(teacher);
    }
}