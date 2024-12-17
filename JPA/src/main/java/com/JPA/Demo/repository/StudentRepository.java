package com.JPA.Demo.repository;

import com.JPA.Demo.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameIgnoreCase(String firstName);
    public List<Student> findByFirstNameContaining(String firstName);
    public List<Student> findByLastNameNotNull();
    public List<Student> findByGuardianName(String guardianName);
    public Student findByFirstNameAndLastName(String firstName, String lastName);

    // JPQL
    @Query("select s.firstName from Student s where s.emailId=?1")
    public String getStudentFirstNameByEmailAddress(String email);

    @Query("select s from Student s where s.emailId=?1")
    public Student getStudentByEmailAddress(String email);

    // Native Query
    @Query(value = "select * from tbl_student where email_address=?1", nativeQuery = true)
    public Student getStudentByEmailAddressNative(String email);

    // Native Named Param
    @Query(value = "select * from tbl_student where email_address = :email", nativeQuery = true)
    public Student getStudentByEmailAddressNativeNamedParam(@Param("email") String email);

    // Update Query with Native SQL
    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name=?1 where email_address=?2", nativeQuery = true)
    public int updateStudentNameByEmailId(String firstName, String email);
}
