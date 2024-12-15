package com.SpringMVC.demo.service;

import com.SpringMVC.demo.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartmentList();

    public Department getDepartmentById(Long id);

    public void deleteDepartment(Long id);

    public Department updateDepartment(Long id,Department department);

    public Department getDepartmentByName(String name);
}
