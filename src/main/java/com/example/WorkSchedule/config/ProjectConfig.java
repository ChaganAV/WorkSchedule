package com.example.WorkSchedule.config;

import com.example.WorkSchedule.models.Parrot;
import nz.net.ultraq.web.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    //@Bean
    public LayoutDialect layoutDialect(){
        return new LayoutDialect();
    }
}
