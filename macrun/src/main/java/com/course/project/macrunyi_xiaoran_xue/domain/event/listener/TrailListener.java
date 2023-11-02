package com.course.project.macrunyi_xiaoran_xue.domain.event.listener;

import com.course.project.macrunyi_xiaoran_xue.cfg.RabbitCfg;
import com.course.project.macrunyi_xiaoran_xue.domain.command.TrailService;
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
public class TrailListener {
    @Resource
    private TrailService trailService;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = RabbitCfg.QUEUE_NAME_USER_REGISTER, durable = "true"),
                    exchange = @Exchange(value = RabbitCfg.EXCHANGE_NAME_USER_REGISTER, ignoreDeclarationExceptions = "true"),
                    key = RabbitCfg.ROUTING_KEY_USER_REGISTER))
    public void receiveMsg(UserEntity payload, Channel channel,
                           @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        log.info("receive message: '" + payload + "'");
        if (payload == null) {
            return;
        }
        trailService.allocateTrail(payload.getUserId(), payload.getLongitude(), payload.getLatitude());
    }
}
