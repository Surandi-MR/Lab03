package com.example.StudentManagementSystem.Service.impl;

import com.example.StudentManagementSystem.Repository.StudentRepository;
import com.example.StudentManagementSystem.Service.StudentService;
import com.example.StudentManagementSystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id){
        Optional<Student> student= studentRepository.findById(id);
        if (student.isPresent()){
            return student.get();
        }
        else{
            throw new RuntimeException();
        }
    }

    @Override
    public Student updateStudent(Student student,long id){
        Student existingStudent=studentRepository.findById(id).orElseThrow(()->new RuntimeException());
    existingStudent.setFirstName(student.getFirstName());
    existingStudent.setLastName(student.getLastName());
    existingStudent.setDepartment(student.getDepartment());
    existingStudent.setEmail(student.getEmail());
    existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());

    studentRepository.save(existingStudent);
    return existingStudent;
    }

    @Override
    public void deleteStudent(long id){
        studentRepository.findById(id).orElseThrow(()->new RuntimeException());
        studentRepository.deleteById(id);

    }

    @Override
    public List<Student>getStudentByYearOfEnrollment(String yearOfEnrollment) {
        return studentRepository.findByYearOfEnrollment(yearOfEnrollment);
    }

    @Override
    public String getDepartmentById(long id){
        return studentRepository.findDepartmentById(id);

    }

    @Override
    public void deleteStudentByYearOfEnrollment(String yearOfEnrollment) {

        studentRepository.deleteAllByYearOfEnrollment(yearOfEnrollment);


    }
}
