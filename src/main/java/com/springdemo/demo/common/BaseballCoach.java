package com.springdemo.demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach{

    public BaseballCoach(){
        System.out.println("Baseball coach");
    }

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("BaseballCoach bean @PostConstruct");
    }

    @PreDestroy
    public void doMyRemoveStuff(){
        System.out.println("BaseballCoach bean @PreDestroy");
    }

    @Override
    public String getDailyWorkouts(){
        return "Practice batting daily";
    }
}

//prototype beans do not run the @PreDestroy hook methods
//prototype beans are lazy by default. So @Lazy decorator is not required