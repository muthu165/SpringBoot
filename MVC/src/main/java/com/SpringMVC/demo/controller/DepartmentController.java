package com.SpringMVC.demo.controller;

import com.SpringMVC.demo.entity.Department;
import com.SpringMVC.demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
//    RequestBody converts to Department format
//    Jackson for obj->json || json->obj
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartmentList(){
        logger.info("inside getDepartmentList of DepartmentController");
        return departmentService.getDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) {
        logger.info("inside getDepartmentById of DepartmentController");
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long id) {
        logger.info("inside deleteDepartment of DepartmentController");
        departmentService.deleteDepartment(id);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
        logger.info("inside updateDepartment of DepartmentController");
        return departmentService.updateDepartment(id,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name) {
        logger.info("inside getDepartmentByName of DepartmentController");
        return departmentService.getDepartmentByName(name);
    }

}

