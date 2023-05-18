package jpadepth;

import jpadepth.entity.Course;
import jpadepth.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest(classes = Root.class)
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepo;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void findById() {
        Course course = courseRepo.findById(6001L);
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

}
