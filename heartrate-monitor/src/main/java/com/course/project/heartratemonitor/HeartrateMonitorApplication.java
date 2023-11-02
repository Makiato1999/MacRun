package com.course.project.heartratemonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling

public class HeartrateMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeartrateMonitorApplication.class, args);
    }

}
