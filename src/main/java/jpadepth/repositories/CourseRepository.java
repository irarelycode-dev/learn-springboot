package jpadepth.repositories;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpadepth.entity.Course;
import jpadepth.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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

    public void addReviewForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);
        for (Review review : reviews) {
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }
    }

}
