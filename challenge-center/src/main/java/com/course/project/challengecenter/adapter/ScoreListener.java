package com.course.project.challengecenter.adapter;

import com.course.project.challengecenter.RabbitConfiguration;
import com.course.project.challengecenter.business.ProfileService;
import com.course.project.useropt.business.entities.UserEntity;
import com.rabbitmq.client.Channel;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
@Component
@Slf4j
public class ScoreListener {
    @Resource
    private ProfileService profileService;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = RabbitConfiguration.QUEUE_NAME_SCORE, durable = "true"),
                    exchange = @Exchange(value = RabbitConfiguration.EXCHANGE_NAME_SCORE, ignoreDeclarationExceptions = "true"),
                    key = RabbitConfiguration.ROUTING_KEY_SCORE))
    public void receiveMsg(UserEntity payload, Channel channel,
                           @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        log.info("receive message: '" + payload + "'");
        if (payload == null) {
            return;
        }


//    ) {
//        log.info("receive score: ");

//        profileService
    }

}