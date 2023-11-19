package com.course.project.trailcenter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TrailCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrailCenterApplication.class, args);
    }
}