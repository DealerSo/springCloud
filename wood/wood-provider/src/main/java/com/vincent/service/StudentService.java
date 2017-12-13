package com.vincent.service;

import com.vincent.bean.Student;

import java.util.List;

public interface StudentService {

    List<Student> listStudent();

    Student findById(Integer id);
}
