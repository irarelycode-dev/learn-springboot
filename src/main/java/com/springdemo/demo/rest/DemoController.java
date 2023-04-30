package com.springdemo.demo.rest;

import com.springdemo.demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach coach){
        myCoach=coach;
    }

    @GetMapping("/daily-workout")
    public String getDailyworkout(){
        return myCoach.getDailyWorkouts();
    }

}
