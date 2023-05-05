package com.springdemo.demo.repositories;

import com.springdemo.demo.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="my-students")
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
