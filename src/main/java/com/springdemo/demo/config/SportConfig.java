package com.springdemo.demo.config;

import com.springdemo.demo.common.Coach;
import com.springdemo.demo.common.CustomBeanCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public Coach customBeanCoach(){
        return new CustomBeanCoach();
    }
}
