package com.example.WorkSchedule.config;

import com.example.WorkSchedule.models.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("Ko-ko");
        return p;
    }
}
