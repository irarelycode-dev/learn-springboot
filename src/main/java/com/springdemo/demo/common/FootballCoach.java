package com.springdemo.demo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class FootballCoach implements Coach {

    public FootballCoach(){
        System.out.println("Football coach constructor");
    }

    @Override
    public String getDailyWorkouts(){
        return "Practice dribbling everyday";
    }
}
