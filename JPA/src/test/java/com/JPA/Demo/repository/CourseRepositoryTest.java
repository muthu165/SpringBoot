package com.JPA.Demo.repository;

import com.JPA.Demo.entity.Course;
import com.JPA.Demo.entity.Student;
import com.JPA.Demo.entity.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.data.domain.Pageable;  // CORRECT import

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    public void fetchAllCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses: " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Raju")
                .lastName("Bhai")
                .build();
        Course course = Course.builder()
                .title("ML")
                .credit(10)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstThreeRecords =  PageRequest.of(0,3);
        Pageable secondTwoRecords = PageRequest.of(1,2);
        Page<Course> coursePage = courseRepository.findAll(secondTwoRecords);
        List<Course> courses = coursePage.getContent();

        long totElements = coursePage.getTotalElements();
        long totPages =  coursePage.getTotalPages();
        System.out.println(totElements + "," + totPages );
        System.out.println("courses: " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitleDesc = PageRequest.of(0,2,Sort.by("title").descending());
        Pageable sortByCredit = PageRequest.of(0,2,Sort.by("credit"));
        Pageable sortByTitleAndCredit = PageRequest.of(0,2,Sort.by("title").descending().and(Sort.by("credit")));
        List<Course> course = courseRepository.findAll(sortByCredit).getContent();
        System.out.println(course);
    }

    @Test
    public void findByTitleContaining(){
        Pageable firstTenRecords =  PageRequest.of(0,10,Sort.by("title"));
        List<Course> courses = courseRepository.findByTitleContaining("M",firstTenRecords).getContent();
        System.out.println("courses: " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Raj")
                .lastName("Bhai")
                .build();

        Student student1 = Student.builder()
                .firstName("Kushi")
                .lastName("Bhai")
                .emailId("KBU@gmail.com")
                .build();

        Course course = Course.builder()
                .title("Analytics")
                .credit(10)
                .teacher(teacher)
//                .students(List.of(student))
                .build();
        course.addStudents(student1);
        courseRepository.save(course);
    }








}