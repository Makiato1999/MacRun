package com.course.project.useropt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UserOptApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserOptApplication.class, args);
    }

}
