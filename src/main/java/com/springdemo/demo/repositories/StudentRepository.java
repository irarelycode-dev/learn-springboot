package com.springdemo.demo.repositories;

import com.springdemo.demo.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<Student,Integer> {
}
