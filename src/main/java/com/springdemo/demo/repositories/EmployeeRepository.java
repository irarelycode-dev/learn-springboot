package com.springdemo.demo.repositories;

import com.springdemo.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
