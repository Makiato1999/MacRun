package com.course.project.gamecenter.domain.events.listener;

import com.course.project.gamecenter.business.entity.UserOptEntity;
import com.rabbitmq.client.Channel;
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
public class UserOptListener {
    //todo
    private static final String QUEUE_NAME_USER_OPT = "user_opt_queue";
    private static final String EXCHANGE_NAME_USER_OPT = "user_opt_exchange";
    private static final String ROUTING_KEY_USER_OPT = "user_opt_routing";

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = QUEUE_NAME_USER_OPT, durable = "true"),
                    exchange = @Exchange(value = EXCHANGE_NAME_USER_OPT, ignoreDeclarationExceptions = "true"),
                    key = ROUTING_KEY_USER_OPT))
    public void receiveMsg(UserOptEntity payload, Channel channel,
                           @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        log.info("GameCenter has received message from user_opt_queue: '" + payload + "'");
        if (payload == null) {
            return;
        }
    }
}
