package com.SpringMVC.demo.repository;

import com.SpringMVC.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepositiory extends JpaRepository<Department,Long> {

    public Department findByDepartmentName(String departmentName);

    //    JPQL
//    @Query(value = "",nativeQuery = true)
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
