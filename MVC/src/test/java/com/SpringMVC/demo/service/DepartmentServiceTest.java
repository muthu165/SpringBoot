package com.SpringMVC.demo.service;

import com.SpringMVC.demo.entity.Department;
import com.SpringMVC.demo.repository.DepartmentRepositiory;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.context.mockito.SpringMockBean;


@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockitoBean
    private DepartmentRepositiory departmentRepositiory;
//    @BeforeEach
//    executes every time before all test defined below

//    BeforeAll executes only once before all test defined below
//    @BeforeAll
    @BeforeEach
     void setUp() {
        Department department = Department.builder()
                .departmentName("CSBS")
                .departmentAddress("Chennai")
                .departmentCode("EUCB034")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepositiory.findByDepartmentNameIgnoreCase("CSBS")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on valid Dept name")
//    @Disabled
    public void whenValidDept_thenDeptFound(){
        String deptName = "CSBS";
        Department department = departmentService.getDepartmentByName(deptName);
        assertEquals(deptName,department.getDepartmentName());
    }
}