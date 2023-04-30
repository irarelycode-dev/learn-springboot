package com.springdemo.demo;

import java.util.*;
import com.springdemo.demo.jpa.dao.StudentDao;
import com.springdemo.demo.jpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.springdemo.demo","utils"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner->{
//			createStudent(studentDao);
//			createMultipleStudents(studentDao);
//			readStudent(studentDao);
//			listStudents(studentDao);
//			listStudentsLastNameAsc(studentDao);
//			listStudentsByLastName(studentDao,"Rao");
//			updateStudentId(studentDao);
//			deleteStudent(studentDao);
//			deleteAll(studentDao);
		};
	}

	private void createStudent(StudentDao studentDao){
		//create student object
		System.out.println("Creating new student object");
		Student tmpStudent=new Student("vignesh","pugazhendhi","vickynsp15@gmail.com");
		//save student object
		studentDao.save(tmpStudent);
		//display the id of saved student
		System.out.println("saved student:"+tmpStudent.getId());
	}

	private void createMultipleStudents(StudentDao studentDao){
		System.out.println("Creating 3 students...");
		Student stud1=new Student("Rochelle","Maria","rochellemariorao@gmail.com");
		Student stud2=new Student("Paloma","Rao","palomarao@gmail.com");
		Student stud3=new Student("Megha","gupta","meghagupta@gmail.com");
		studentDao.save(stud1);
		studentDao.save(stud2);
		studentDao.save(stud3);
		System.out.println("Saved all 3 students");
	}

	private void readStudent(StudentDao studentDao){
		System.out.println(studentDao.findById(3001));
	}

	private void listStudents(StudentDao studentDao){
		List<Student> students=studentDao.findAll();
		System.out.println("List:"+students);
	}

	private void listStudentsLastNameAsc(StudentDao studentDao){
		List<Student> students=studentDao.findAllLastNameAsc();
		System.out.println("List:"+students);
	}

	private void listStudentsByLastName(StudentDao studentDao,String lastName){
		List<Student> students=studentDao.getByLastName(lastName);
		System.out.println("List:"+students);
	}

	private void updateStudentId(StudentDao studentDao){
		int studentId=1;
		System.out.println("student before update:");
		Student student=studentDao.findById(studentId);
		System.out.println(student);
		student.setFirstName("vicky");
		studentDao.update(student);
		System.out.println("Updated student:"+student);
	}

	private void deleteStudent(StudentDao studentDao){
		int studentId=3;
		studentDao.deleteStudent(studentId);
	}

	private void deleteAll(StudentDao studentDao){
		System.out.println("Deleted entries:"+studentDao.deleteAll());
	}

}