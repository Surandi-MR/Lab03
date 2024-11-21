package com.example.StudentManagementSystem.Service;
import com.example.StudentManagementSystem.model.Student;
import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student>getAllStudent();
    Student getStudentById(long id);
    Student updateStudent(Student student,long id);
    void deleteStudent(long id);
    List<Student>getStudentByYearOfEnrollment(String yearOfEnrollment);
    String getDepartmentById(long id);
    void deleteStudentByYearOfEnrollment(String yearOfEnrollment);

}
