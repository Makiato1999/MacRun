package com.course.project.gamecenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GameCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameCenterApplication.class, args);
    }

}
