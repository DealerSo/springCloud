package com.vincent.controller;


import com.vincent.bean.Student;
import com.vincent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/provider")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/getStudentList")
    public List<Student> getStudentList(){
        return studentService.listStudent();
    }
    @GetMapping(value = "findStudent/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.findById(id);
    }

}
