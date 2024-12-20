package com.SpringMVC.demo.service;

import com.SpringMVC.demo.entity.Department;
import com.SpringMVC.demo.error.DepartmentNotFoundException;
import com.SpringMVC.demo.repository.DepartmentRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentRepositiory departmentRepositiory;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepositiory.save(department);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentRepositiory.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepositiory.findById(id);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not found with id: " + id);
        }
        return department.get();
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepositiory.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) throws DepartmentNotFoundException {
//        RuntimeException || DepartmentNotFoundException
        Department oldDepartment = departmentRepositiory.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department with ID " + id + " not found"));

        if(Objects.nonNull(oldDepartment.getDepartmentName()) &&
        !"".equalsIgnoreCase(oldDepartment.getDepartmentName())){
            oldDepartment.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(oldDepartment.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(oldDepartment.getDepartmentAddress())){
            oldDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(oldDepartment.getDepartmentCode()) &&
                !"".equalsIgnoreCase(oldDepartment.getDepartmentCode())){
            oldDepartment.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepositiory.save(oldDepartment);
    }

    @Override
    public Department getDepartmentByName(String name) {
        if(departmentRepositiory.findByDepartmentName(name) != null){
            return departmentRepositiory.findByDepartmentName(name);
        }
        return departmentRepositiory.findByDepartmentNameIgnoreCase(name);

    }
}
