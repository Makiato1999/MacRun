package com.course.project.eurekayi_xiaoran_xue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }
}

/**
 * ==> issue:
 * I can't start eureka server and access http://localhost:8761/
 * <p>
 * ==> solution:
 * https://stackoverflow.com/questions/56943586/not-able-to-start-eureka-server
 * <p>
 * Make sure Spring Cloud Version and Spring Version is supposed to work together,
 * Check the compatible versions here:
 * https://spring.io/projects/spring-cloud
 */

