package com.course.project.challengecenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.course.project.challengecenter.business.entity")
//@EnableJpaRepositories("com.course.project.challengecenter.port")
public class ChallengeCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChallengeCenterApplication.class, args);
    }

}
