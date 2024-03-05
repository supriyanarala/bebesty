package com.experiment.bebesty.service;


import com.experiment.bebesty.model.Student;
import com.experiment.bebesty.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    //get all students
    public List<Student> getAllStudents() {

        return this.studentRepository.findAll();
    }
    //add new student
    public String addStudent(Student newStudent) {
        this.studentRepository.save(newStudent);
        return "Student data added";
    }
    //update student
    public String updateStudent(Integer studentId, Student updatedStudent)
    {
        Student oldStudentsData = this.studentRepository.findById(studentId).get();
        if(this.studentRepository.findById(studentId).isPresent()){
            oldStudentsData.setEmail(updatedStudent.getEmail());
            oldStudentsData.setLocation(updatedStudent.getLocation());
            oldStudentsData.setStudentname(updatedStudent.getStudentname());
            this.studentRepository.save(oldStudentsData);
        }
        return "Data updated";

    }

    //delete student
    public void deleteStudent(Integer studentId) {
        if(this.studentRepository.findById(studentId).isPresent()) {
            this.studentRepository.deleteById(studentId);
        }
    }
    //get single student
    public Student getStudentData(Integer studentId){
        Student selectedStudent = null;
        if(this.studentRepository.findById(studentId).isPresent()) {
            selectedStudent = this.studentRepository.findById(studentId).get();
        }
        return selectedStudent;
    }

}
