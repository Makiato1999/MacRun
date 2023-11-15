package com.course.project.gamecenter.domain.events.listener;

import com.course.project.gamecenter.dto.GameAttackReq;
import com.course.project.gamecenter.port.GameCenterService;
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
public class UserHRMListener {

    //todo
    private static final String QUEUE_NAME = "user_hrm_queue";
    private static final String EXCHANGE_NAME = "user_hrm_exchange";
    private static final String ROUTING_KEY = "user_hrm_routing";

    @Resource
    private GameCenterService gameCenterService;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = QUEUE_NAME, durable = "true"),
                    exchange = @Exchange(value = EXCHANGE_NAME, ignoreDeclarationExceptions = "true"),
                    key = ROUTING_KEY))
    public void receiveMsg(GameAttackReq payload, Channel channel,
                           @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        if (payload == null) {
            return;
        }

        log.info("【Scenario302 - GameCenter】-【GameCenter】receive mq msg from【HRM】, userId={},heartRate={}",
                payload.getUserId(), payload.getHeartRateCnt());

        gameCenterService.generateAttackMode(payload);
    }
}
