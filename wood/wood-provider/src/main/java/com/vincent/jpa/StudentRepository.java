package com.vincent.jpa;

import com.vincent.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
