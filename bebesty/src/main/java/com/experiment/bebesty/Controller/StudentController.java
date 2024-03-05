package com.experiment.bebesty.Controller;

import com.experiment.bebesty.model.Student;
import com.experiment.bebesty.service.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return this.studentService.getAllStudents();
    }

    @PostMapping("/addstudent")
    public String addNewStudent(@RequestBody Student studentData){
        return this.studentService.addStudent(studentData);
    }

    @PutMapping("/update/{studentId}")
    public String updateStudent(@PathVariable Integer studentId, Student newData){
        return this.studentService.updateStudent(studentId,newData);
    }

    @DeleteMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable Integer studentId){
        this.studentService.deleteStudent(studentId);
        return "Student with id "+studentId +" is deleted";
    }

    @GetMapping("/student/{studentId}")
    public Student getSingleStudent(@PathVariable Integer studentId){
        Student std = this.studentService.getStudentData(studentId);
//        System.out.println("id "+std.getStudentId());
//        System.out.println("name "+std.getStudentname());
//        System.out.println("email "+std.getEmail());
//        System.out.println("location "+std.getLocation());
        return std;
    }
}
