//package jpaandhibernate;
//
//import jpaandhibernate.jdbc.Person;
//import jpaandhibernate.jdbc.PersonJdbcDao;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.*;
//
//@SpringBootApplication(scanBasePackages = {"jpaandhibernate"})
//public class Boot implements CommandLineRunner {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    PersonJdbcDao personDao;
//
//    public static void main(String[] args) {
//        SpringApplication.run(Boot.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        List<Person> entries = personDao.findAll();
//        for (Person entry : entries) {
//            System.out.println(entry);
//        }
//
//        Person person = personDao.findById(1001);
//        System.out.println(person);
//
//        System.out.println("Deleted person with id:1001->>>" + personDao.deleteById(1001));
//        System.out.println("Update person with id:1002->>>>" + personDao.update(new Person(1002, "updated", "update", new Date())));
//
//    }
//}
