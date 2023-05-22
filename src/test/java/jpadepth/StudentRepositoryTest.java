package jpadepth;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpadepth.entity.Passport;
import jpadepth.entity.Student;
import jpadepth.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Root.class)
public class StudentRepositoryTest {

    private static Logger logger = LoggerFactory.getLogger(StudentRepositoryTest.class);

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student->{}", student);
        logger.info("passport->{}", student.getPassport());
    }

    @Test
    @Transactional
    public void someTest() {
        Student student = em.find(Student.class, 20001L);
        Passport passport = student.getPassport();
        passport.setNumber("L001EDM");
        student.setName("Ranga-updated");
    }

}
