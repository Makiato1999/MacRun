package com.course.project.gamecenter.domain.events.producer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Slf4j
@SpringBootTest
public class UserScoreProducerTest {
    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private UserScoreProducer userScoreProducer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSender() {
        Object testMsg = new Object();
        userScoreProducer.sender(testMsg);

        verify(rabbitTemplate, times(1))
                .convertAndSend(UserScoreProducer.EXCHANGE_NAME,
                        UserScoreProducer.ROUTING_NAME,
                        testMsg);
    }
}