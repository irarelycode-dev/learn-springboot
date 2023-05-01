package com.springdemo.demo.rest;

import com.springdemo.demo.entity.Employee;
import com.springdemo.demo.jpa.dao.EmployeeDao;
import com.springdemo.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee=employeeService.findById(employeeId);
        if(employee==null) throw new RuntimeException("Employee id not found-"+employeeId);
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        //just in case they pass id in json,
        //this is to force a save of new item... instead of update
        employee.setId(0);
        Employee dbEmployee=employeeService.save(employee);
        return  dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee=employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tmpEmployee= employeeService.findById(employeeId);
        if(tmpEmployee==null) throw new RuntimeException("Employee id not found-"+employeeId);
        employeeService.deleteById(employeeId);
        return "Deleted employee with id-"+employeeId;
    }

}
