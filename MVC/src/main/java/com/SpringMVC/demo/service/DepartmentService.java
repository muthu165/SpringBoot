package com.SpringMVC.demo.service;

import com.SpringMVC.demo.entity.Department;
import com.SpringMVC.demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartmentList();

    public Department getDepartmentById(Long id) throws DepartmentNotFoundException;

    public void deleteDepartment(Long id);

    public Department updateDepartment(Long id,Department department) throws DepartmentNotFoundException;

    public Department getDepartmentByName(String name);
}
