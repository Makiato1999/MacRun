package com.course.project.gamecenter.domain.events.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PlayModeUIProduce {

    //todo
    public static final String EXCHANGE_NAME = "play_mode_ui_exchange";
    public static final String ROUTING_NAME = "play_mode_ui_rounting";

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public PlayModeUIProduce(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sender(Object msg) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_NAME, msg);
    }
}
