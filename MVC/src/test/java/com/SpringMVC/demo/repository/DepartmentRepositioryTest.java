package com.SpringMVC.demo.repository;

import com.SpringMVC.demo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositioryTest {
    @Autowired
    private DepartmentRepositiory departmentRepositiory;
    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("EEE")
                .departmentCode("AWS")
                .departmentAddress("TCS-CSBS")
                .build();
        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = departmentRepositiory.findById(1L).get();
        assertEquals("EEE", department.getDepartmentName());
    }
}