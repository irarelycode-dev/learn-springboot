package com.springdemo.demo.jpa.dao;

import com.springdemo.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeImpl implements EmployeeDao{
    @Override
    public Employee findById(int id) {
        Employee employee=entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee tmpEmployee=entityManager.merge(employee);
        return tmpEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee employee=entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }

    private EntityManager entityManager;

    @Autowired
    public EmployeeImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll(){
        TypedQuery<Employee> query=entityManager.createQuery("from Employee",Employee.class);
        return query.getResultList();
    }
}
