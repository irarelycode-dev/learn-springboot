package com.springdemo.demo.jpa.dao;

import java.util.*;
import com.springdemo.demo.jpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentImpl implements StudentDao{

    private EntityManager entityManager;

    @Autowired
    public void StudentImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id){
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll(){
        TypedQuery<Student> query=entityManager.createQuery("from Student",Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findAllLastNameAsc(){
        TypedQuery<Student> query=entityManager.createQuery("from Student order by lastName asc",Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> getByLastName(String lastName){
        TypedQuery<Student> query=entityManager.createQuery("from Student where lastName=:data",Student.class);
        query.setParameter("data",lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student){
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id){
        TypedQuery<Student> query=entityManager.createQuery("from Student where id=:id",Student.class);
        query.setParameter("id",id);
        System.out.println("Before deleting");
        Student student=query.getSingleResult();
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll(){
        return entityManager.createQuery("delete from Student").executeUpdate();
    }


}
