package com.course.project.trailcenter.domain.producer;

import com.course.project.trailcenter.RabbitConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TrailCenterProducer {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public TrailCenterProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sender(Object msg) {
        rabbitTemplate.convertAndSend(RabbitConfiguration.EXCHANGE_NAME_TRAIL_ALLOCATION, RabbitConfiguration.ROUTING_KEY_TRAIL_ALLOCATION, msg);
        log.info("TrailCenter has sent message: '" + msg + "'");
    }
}