package com.example.WorkSchedule;

import com.example.WorkSchedule.config.ProjectConfig;
import com.example.WorkSchedule.models.Parrot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class WorkScheduleApplication {

	public static void main(String[] args) {

		SpringApplication.run(WorkScheduleApplication.class, args);
//		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
//		Parrot p = context.getBean(Parrot.class);
//		System.out.println(p.getName());
	}

}
