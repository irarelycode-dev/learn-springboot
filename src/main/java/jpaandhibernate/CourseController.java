package jpaandhibernate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> getCourses(){
        return Arrays.asList(new Course(1,"learn aws","in28minutes"),new Course(2,"learn devops","in28minutes"));
    }
}
