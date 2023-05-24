package jpadepth.repositories;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpadepth.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public void insert(Employee employee) {
        em.persist(employee);
    }

    public List<Employee> retrieveFullTimeEmployees() {
        return em.createQuery("select e from FullTimeEmployee e", Employee.class).getResultList();
    }

}
