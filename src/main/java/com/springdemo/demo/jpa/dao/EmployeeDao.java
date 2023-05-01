package com.springdemo.demo.jpa.dao;

import java.util.*;
import com.springdemo.demo.entity.Employee;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
