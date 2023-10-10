package com.course.project.macrunyi_xiaoran_xue.mq.listener;

import com.course.project.macrunyi_xiaoran_xue.cnfg.RabbitCnfg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import com.rabbitmq.client.Channel;

@Component
@Slf4j
public class TestListener {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = RabbitCnfg.QUEUE_NAME, durable = "true"),
                    exchange = @Exchange(value = RabbitCnfg.EXCHANGE_NAME, ignoreDeclarationExceptions = "true"),
                    key = RabbitCnfg.ROUTING_KEY))
    public void receiveMsg(String payload, Channel channel,
                           @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        log.info("receive message: '" + payload + "'");
    }
}
