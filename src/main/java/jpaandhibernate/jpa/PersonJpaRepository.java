package jpaandhibernate.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Transactional
public class PersonJpaRepository {
    @PersistenceContext
    EntityManager entityManager;

    //with jpql-java persistence query language
    public List<Person> findAll(){
        TypedQuery<Person> namedQuery=entityManager.createNamedQuery("find_all_persons",Person.class);
        return namedQuery.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }

}
