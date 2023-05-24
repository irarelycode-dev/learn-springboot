package jpadepth;

import jpadepth.entity.Course;
import jpadepth.entity.Review;
import jpadepth.entity.Student;
import jpadepth.repositories.CourseRepository;
import jpadepth.repositories.StudentRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"jpadepth"})
public class Root implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    StudentRepository studentRepo;

    private final Logger logger = LoggerFactory.getLogger(Root.class);

    @Override
    public void run(String... args) throws Exception {
        //findById
        Course course = courseRepo.findById(1L);
        logger.info("course with id 1: " + course);

        //deleteById
        courseRepo.deleteById(2L);

        //persist a new course
        Course newCourse = courseRepo.save(new Course("Microservices in 10 steps"));
        logger.info("new course inserted: " + newCourse);

        //play with entity manager
        courseRepo.playWithEntityManager();

        //ManyToOne
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("4.3", "Could have been better but it was good"));
        reviews.add(new Review("5.0", "All set to be perfect"));
        courseRepo.addReviewForCourse(10003L, reviews);
        studentRepo.insertStudentAndCourse(new Student("Jack"), new Course("Microservices in golang"));

    }

    public static void main(String[] args) {
        SpringApplication.run(Root.class, args);
    }
}
