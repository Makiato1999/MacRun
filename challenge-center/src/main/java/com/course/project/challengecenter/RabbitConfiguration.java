package com.course.project.challengecenter;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RabbitConfiguration {
    public static final String QUEUE_HELLO_WORLD = "hello-world";

    public static final String ROUTING_HELLO_WORLD = "world.hello";
    public static final String EXCHANGE_NAME = "hello-world-exchange";

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
}
