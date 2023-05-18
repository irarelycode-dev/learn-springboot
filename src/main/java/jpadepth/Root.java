package jpadepth;

import jpadepth.entity.Course;
import jpadepth.repositories.CourseRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"jpadepth"})
public class Root implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepo;

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

    }

    public static void main(String[] args) {
        SpringApplication.run(Root.class, args);
    }
}
