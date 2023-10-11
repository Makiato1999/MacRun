package com.course.project.macrunyi_xiaoran_xue.mq.producer;

import com.course.project.macrunyi_xiaoran_xue.cnfg.RabbitCnfg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestSender {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public TestSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sender(String msg) {
        rabbitTemplate.convertAndSend(RabbitCnfg.EXCHANGE_NAME, RabbitCnfg.ROUTING_KEY, msg);
    }
}
