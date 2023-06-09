package com.springdemo.demo.service;

import com.springdemo.demo.entity.Employee;
import com.springdemo.demo.jpa.dao.EmployeeDao;
import com.springdemo.demo.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

//    @Autowired
//    public EmployeeServiceImpl(EmpRepository employeeRepository){
//        this.employeeRepository=employeeRepository;
//    }

    //remove @Transactional annotation since JPA handles it

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
