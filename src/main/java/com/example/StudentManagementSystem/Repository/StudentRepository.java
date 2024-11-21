package com.example.StudentManagementSystem.Repository;

import com.example.StudentManagementSystem.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByYearOfEnrollment(String yearOfEnrollment);
    @Query("SELECT s.department FROM Student s WHERE s.id = :id")
    String findDepartmentById (@Param("id")Long id);
    @Transactional
    @Modifying
    @Query("DELETE FROM Student s WHERE s.yearOfEnrollment = :yearOfEnrollment")
    void deleteAllByYearOfEnrollment(@Param("yearOfEnrollment") String yearOfEnrollment);
}
