package jpadepth.repositories;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpadepth.entity.Course;
import jpadepth.entity.Passport;
import jpadepth.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        if (student != null) em.remove(student);
    }

    public Student save() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);
        Student student = new Student("Mike");
        student.setPassport(passport);
        em.persist(student);
        return student;
    }

    public void insertStudentAndCourse(Student student,Course course) {
        em.persist(student);
        em.persist(course);
        student.setCourse(course);
        course.setStudent(student);
        em.persist(student);
    }

}
