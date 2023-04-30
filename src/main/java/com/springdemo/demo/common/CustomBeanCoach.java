package com.springdemo.demo.common;

public class CustomBeanCoach implements Coach{

    public CustomBeanCoach(){
        System.out.println("CustomBeanCoach constructor");
    }

    @Override
    public String getDailyWorkouts(){
        return "Do 10 laps daily";
    }
}
