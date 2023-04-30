package com.springdemo.demo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class HockeyCoach implements Coach{

    public HockeyCoach(){
        System.out.println("Hockey coach constructor");
    }

    @Override
    public String getDailyWorkouts(){
        return "Practice hitting shots daily";
    }
}
