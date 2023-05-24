package jpadepth;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpadepth.entity.Course;
import jpadepth.entity.Review;
import jpadepth.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = Root.class)
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    EntityManager em;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void findById() {
        Course course = courseRepo.findById(10001L);
        assertEquals("JPA in 50 steps", course.getName());
    }

    @Test
    @DirtiesContext  //reset the data after this test
    public void deleteById() {
        courseRepo.deleteById(2001L);
        Course course = courseRepo.findById(2001L);
        assertNull(course);
    }

    @Test
    @DirtiesContext
    public void updateCourse() {
        Course course = courseRepo.findById(1L);
        assertEquals("Microservices in 10 steps", course.getName());
        course.setName("JPA in 50 steps-Updated");
        courseRepo.save(course);

        Course tmp = courseRepo.findById(1L);
        assertEquals("JPA in 50 steps-Updated", tmp.getName());

    }

    @Test
    @DirtiesContext
    public void playWithEntityManager() {
        courseRepo.playWithEntityManager();
    }

    @Test
    @Transactional
    public void retrieveReviewsForCourse() {
        Course course = courseRepo.findById(10001L);
        assertNotEquals(course.getReviews().size(), 0);
    }

    @Test
    public void retrieveCourseForReviews() {
        Review review = em.find(Review.class, 50001L);
        Course course = review.getCourse();
        assertNotEquals(course.getName().length(), 0);
    }

}
