package com.SpringMVC.demo.controller;

import com.SpringMVC.demo.entity.Department;
import com.SpringMVC.demo.error.DepartmentNotFoundException;
import com.SpringMVC.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Department department;

    @MockitoBean
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("EEE")
                .departmentAddress("TCS-CSBS")
                .departmentCode("AWS")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputdepartment = Department.builder()
                .departmentName("EEE")
                .departmentAddress("TCS-CSBS")
                .departmentCode("AWS")
                .build();

        Mockito.when(departmentService.saveDepartment(inputdepartment))
                .thenReturn(department);

        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"EEE\",\n" +
                        "    \"departmentAddress\":\"TCS-CSBS\",\n" +
                        "    \"departmentCode\":\"AWS\"\n" +
                        "}"))
                .andExpect(status().isOk());
// option + return ondemand static import
    }

    @Test
    void getDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);
        mockMvc.perform(get("/departments/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
//        jsonPath -> indicates value in mock should match with input value


    }
}