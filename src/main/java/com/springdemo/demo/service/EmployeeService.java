package com.springdemo.demo.service;

import com.springdemo.demo.entity.Employee;
import java.util.*;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
