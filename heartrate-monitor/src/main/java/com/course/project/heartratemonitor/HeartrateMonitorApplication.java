package com.course.project.heartratemonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling

public class HeartrateMonitorApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HeartrateMonitorApplication.class);
        // not sure why it uses netty and need to manually change port
        app.setDefaultProperties(Collections.singletonMap("server.port", "8082"));
        app.run(args);
//        SpringApplication.run(HeartrateMonitorApplication.class, args);
    }

}
