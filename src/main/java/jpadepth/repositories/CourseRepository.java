package jpadepth.repositories;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpadepth.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        if (course != null) em.remove(course);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            //insert
            em.persist(course);
        } else {
            //update
            em.merge(course);
        }
        return course;
    }

    //since this is transactional, all the lines inside this method are updated
    public void playWithEntityManager() {
        Course course1 = new Course("Webservices in 100 steps");
        em.persist(course1);
        em.flush();
        course1.setName("Webservices in 100 steps-Updated");
        em.flush();

        Course course2 = new Course("Angularjs in 100 steps");
        em.persist(course2);
        em.flush();

        em.detach(course2);
        //instead of detaching with individual objects, you can use em.clear()
        course2.setName("Angularjs in 100 steps-Updated");
        em.flush();


        Course course3 = new Course("GraphQL in 100 steps");
        em.persist(course3);
        course3.setName("GraphQL in 100 steps-Updated");
        em.refresh(course3);

    }

}
