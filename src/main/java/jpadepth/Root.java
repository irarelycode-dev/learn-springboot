package jpadepth;

import jakarta.transaction.Transactional;
import jpadepth.entity.*;
import jpadepth.entity.manytomany.courses.ConcordiaCourse;
import jpadepth.entity.manytomany.courses.ConcordiaCourseRating;
import jpadepth.entity.manytomany.courses.ConcordiaCourseRatingKey;
import jpadepth.entity.manytomany.courses.ConcordiaStudent;
import jpadepth.entity.manytomany.employees.EmployeePkId;
import jpadepth.entity.manytomany.mentors.Graduates;
import jpadepth.entity.manytomany.mentors.Mentors;
import jpadepth.entity.manytomany.songs.Song;
import jpadepth.entity.manytomany.songs.SongId;
import jpadepth.repositories.CourseRepository;
import jpadepth.repositories.EmployeeRepository;
import jpadepth.repositories.StudentRepository;
import jpadepth.repositories.manytomany.*;
import jpadepth.services.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"jpadepth"})
public class Root implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    StudentRepository studentRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @Autowired
    EmpRepository empRepository;

    @Autowired
    SongsRepository songsRepo;

    @Autowired
    ConcordiaCourseRatingRepository cCourseRatingRepo;

    @Autowired
    ConcordiaCourseRepository cCourseRepo;

    @Autowired
    ConcordiaStudentRepository cStudentRepo;

    @Autowired
    ConcordiaStudentService cStudentService;

    @Autowired
    ConcordiaCourseService cCourseService;

    @Autowired
    ConcordiaCourseRatingService cCourseRatingService;

    @Autowired
    GraduateService graduateService;

    @Autowired
    MentorService mentorService;

    private final Logger logger = LoggerFactory.getLogger(Root.class);

    @Override
    @Transactional
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
        List<Course> studentCourses = studentRepo.getStudentCourses(1L);
        System.out.println("student course length:" + studentCourses.size());

        //inheritance
        employeeRepo.insert(new FullTimeEmployee("Jill", new BigDecimal("50")));
        employeeRepo.insert(new FullTimeEmployee("Joe", new BigDecimal("34")));
        List<Employee> employees = employeeRepo.retrieveFullTimeEmployees();

//        empRepository.save(new jpadepth.entity.manytomany.employees.Employee(101, 10, "basanth", "basanth@gmail.com", "123456"));
//        empRepository.save(new jpadepth.entity.manytomany.employees.Employee(101, 10, "basanth", "basanth@gmail.com", "123456"));
//        empRepository.save(new jpadepth.entity.manytomany.employees.Employee(101, 10, "basanth", "basanth@gmail.com", "123456"));
//        empRepository.save(new jpadepth.entity.manytomany.employees.Employee(101, 10, "basanth", "basanth@gmail.com", "123456"));

        empRepository.save(new jpadepth.entity.manytomany.employees.Employee(new EmployeePkId(100, 10), "basanth", "basanth@gmail.com", "1234567"));
        empRepository.save(new jpadepth.entity.manytomany.employees.Employee(new EmployeePkId(100, 10), "basanth", "basanth@gmail.com", "1234567"));
        empRepository.save(new jpadepth.entity.manytomany.employees.Employee(new EmployeePkId(100, 10), "basanth", "basanth@gmail.com", "1234567"));

        SongId songId = new SongId("teenage dreams", "teenage dreams", "katy perry");
        Song song = new Song(songId, 23, null, null, 4, "http://download.this.song");
        songsRepo.save(song);

//        ConcordiaCourse cCourse = new ConcordiaCourse("Test course");
//        ConcordiaStudent cStudent = new ConcordiaStudent("Some random student");
//        cCourseRepo.save(cCourse);
//        cStudentRepo.save(cStudent);
//        ConcordiaCourseRatingKey ratingKey = new ConcordiaCourseRatingKey(cStudent.getId(), cCourse.getId());
//        ConcordiaCourseRating rating = new ConcordiaCourseRating(ratingKey, "Worst professor ever");
//        rating.setStudent(cStudent);
//        rating.setCourse(cCourse);
//        cCourseRatingRepo.save(rating);
//        cCourse.addRatings(rating);
//        cStudent.addRating(rating);

        System.out.println("size:" + cStudentService.findAll().size());
        System.out.println("size courses:" + cCourseService.findAll().size());

        ConcordiaStudent student = cStudentService.save(new ConcordiaStudent("Some ranom student"));
        ConcordiaCourse tmpC = cCourseService.save(new ConcordiaCourse("Test course"));
        ConcordiaCourseRating rating = new ConcordiaCourseRating(new ConcordiaCourseRatingKey(student.getId(), tmpC.getId()), "Worst prof ever");
        rating.setCourse(tmpC);
        rating.setStudent(student);
        rating = cCourseRatingService.save(rating);
        student.addRating(rating);
        tmpC.addRatings(rating);

        System.out.println("student's rating:" + student + student.getRatings().size());


        //many-to-many
        //graduates and mentors
        List<Graduates> graduates = graduateService.getGraduates();
        System.out.println("graduates length:" + graduates.size());
        List<Mentors> mentors = mentorService.getAllMentors();
        System.out.println("mentors length:" + mentors.size());


    }

    public static void main(String[] args) {
        SpringApplication.run(Root.class, args);
    }
}
