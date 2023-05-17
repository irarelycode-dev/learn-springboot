package jpaandhibernate;

import jpaandhibernate.jpa.Person;
import jpaandhibernate.jpa.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication(scanBasePackages = {"jpaandhibernate"})
public class BootJpa implements CommandLineRunner {

    @Autowired
    PersonJpaRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(BootJpa.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(personRepository.findAll());
        Person person = personRepository.findById(1001);
        System.out.println("person with id 1001->>>" + person);
        System.out.println("person with id 1001 updated->>>>" + personRepository.update(new Person(1001, "updated twice", "twice update", new Date())));
        System.out.println("insert a new person:" + personRepository.insert(new Person("Person", "new", new Date())));
        personRepository.deleteById(1001);
        System.out.println(personRepository.findAll());
    }

}
