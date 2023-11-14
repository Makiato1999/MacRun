package com.course.project.gamecenter.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
public class RabbitConfigurationTest {

    @Resource
    private ApplicationContext context;

    @Test
    public void testJackson2JsonMessageConverterBean() {
        // Assert that the bean is registered
        assertTrue(context.containsBean("converter"));

        // Retrieve the bean and verify its configuration
        Jackson2JsonMessageConverter converter = context.getBean(Jackson2JsonMessageConverter.class);
        assertNotNull(converter);

        // Verify that WRITE_DATES_AS_TIMESTAMPS is set to true
        ObjectMapper objectMapper = (ObjectMapper) converter.getClassMapper();
        assertTrue(objectMapper.getSerializationConfig().isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS));
    }

}