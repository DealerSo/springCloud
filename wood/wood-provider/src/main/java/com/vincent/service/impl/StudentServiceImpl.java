package com.vincent.service.impl;

import com.vincent.bean.Student;
import com.vincent.jpa.StudentRepository;
import com.vincent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    public StudentRepository studentRepository;

    @Override
    public List<Student> listStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findOne(id);
    }
}
