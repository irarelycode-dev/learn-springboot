package com.springdemo.demo.rest;

import com.springdemo.demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/setter")
@RequestMapping(path = "/setter")
public class SetterController {
    private Coach coach;
    private Coach customCoach;

    @Autowired
    public SetterController(@Qualifier("cricketCoach") Coach coach,@Qualifier("customBeanCoach") Coach tmpCoach){
        this.coach=coach;
        customCoach=tmpCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return coach.getDailyWorkouts();
    }

    @GetMapping("/custom-bean-coach")
    public String customBeanCoach(){
        return this.customCoach.getDailyWorkouts();
    }

}
