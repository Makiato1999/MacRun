package com.course.project.useropt.domain.producer;

import com.course.project.useropt.RabbitConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserOptProducer {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public UserOptProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sender(Object msg) {
        log.info("UserOpt has sent message to game_center_queue: '" + msg + "'");
        rabbitTemplate.convertAndSend(RabbitConfiguration.EXCHANGE_NAME_USER_OPT, RabbitConfiguration.ROUTING_KEY_USER_OPT, msg);
    }
}
