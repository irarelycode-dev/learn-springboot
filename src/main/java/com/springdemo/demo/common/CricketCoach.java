package com.springdemo.demo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.springdemo.demo.common.Coach;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("Cricket coach");
    }

    @Override
    public String getDailyWorkouts(){
        return "Practice fast bowling for atleast 15 minutes!!!";
    }
}
