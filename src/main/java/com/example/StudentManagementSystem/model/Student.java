package com.example.StudentManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "First_name",nullable = false)
    private String firstName;
    @Column(name = "Last_name",nullable = false)
    private String lastName;
    @Column(name = "Email_id",nullable = false,unique = true)
    private String email;
    @Column(name = "Department",nullable = false)
    private String department;
    @Column(name = "YearOfEnrollment",nullable = false)
    private String yearOfEnrollment;


}
