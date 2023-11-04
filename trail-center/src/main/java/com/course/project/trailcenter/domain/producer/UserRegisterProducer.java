package com.course.project.trailcenter.domain.producer;

import com.course.project.trailcenter.CfgEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserRegisterProducer {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public UserRegisterProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendTrail(Object msg) {
        rabbitTemplate.convertAndSend(CfgEnum.USER_REGISTER.getQUEUE_NAME(), CfgEnum.USER_REGISTER.getROUTING_NAME(), msg);
    }
}