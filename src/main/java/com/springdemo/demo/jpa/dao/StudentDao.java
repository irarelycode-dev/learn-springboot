package com.springdemo.demo.jpa.dao;

import java.util.*;
import com.springdemo.demo.jpa.entity.Student;

public interface StudentDao {
    void save(Student theStudent);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findAllLastNameAsc();

    List<Student> getByLastName(String lastName);
    void update(Student student);
    void deleteStudent(int id);
    int deleteAll();
}
