package com.springdemo.demo.rest;

import com.springdemo.demo.entity.Student;
import com.springdemo.demo.rest.errorresponse.StudentErrorResponse;
import com.springdemo.demo.rest.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.*;

@RestController
@RequestMapping("/api")
public class RestApiTwo {

    List<Student> students;

    @PostConstruct
    public void loadData(){
        students=new ArrayList<>();
        students.add(new Student("poornima","patel"));
        students.add(new Student("vignesh","pugazhendhi"));
        students.add(new Student("Mario","Rassi"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if(studentId>=students.size()||studentId<0) throw new StudentNotFoundException("Student id not found-"+studentId);

        return students.get(studentId);
    }

    //add exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(404);
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //add exception handler to catch any type of exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAllException(Exception e){
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
