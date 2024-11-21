package com.example.StudentManagementSystem.Controller;

import com.example.StudentManagementSystem.Service.StudentService;
import com.example.StudentManagementSystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student>saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student>getStudentById(@PathVariable("id") long studentID){
        return  new ResponseEntity<Student>(studentService.getStudentById(studentID),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id,@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted Successfully.",HttpStatus.OK);
    }

    @GetMapping("/YearOfEnrollment/{yearOfEnrollment}")
    public ResponseEntity<List<Student>>
    getStudentByYearOfEnrollment(@PathVariable("yearOfEnrollment")String yearOfEnrollment){
        List<Student> student = studentService.getStudentByYearOfEnrollment(yearOfEnrollment);
        return new ResponseEntity<>(student,HttpStatus.OK);

    }

    @GetMapping("/department/{id}")
    public ResponseEntity<String> getDepartmentById(@PathVariable("id")long id){
        String department = studentService.getDepartmentById(id);
        return new ResponseEntity<String>(department,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{year}")
    public String deleteStudentByYearOfEnrollment(@PathVariable("year") String year){
        studentService.deleteStudentByYearOfEnrollment(year);
        return "Students Removed";
    }
}
