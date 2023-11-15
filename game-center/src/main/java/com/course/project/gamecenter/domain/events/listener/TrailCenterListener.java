package com.course.project.gamecenter.domain.events.listener;

import com.course.project.gamecenter.business.entity.TrailEntity;
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
public class TrailCenterListener {

    //todo
    private static final String QUEUE_NAME_TRAIL = "trail_allocation_queue";
    private static final String EXCHANGE_NAME_TRAIL = "trail_allocation_exchange";
    private static final String ROUTING_KEY_TRAIL = "trail_allocation_routing";

    @Resource
    private GameCenterService gameCenterService;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = QUEUE_NAME_TRAIL, durable = "true"), exchange = @Exchange(value = EXCHANGE_NAME_TRAIL, ignoreDeclarationExceptions = "true"), key = ROUTING_KEY_TRAIL))
    public void receiveMsg(TrailEntity payload, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        if (payload == null || payload.getUserId() == null || payload.getTrailId() == null) {
            return;
        }

        log.info("【Scenario3 - GameCenter】-【GameCenter】receive mq msg from【Trail Center】, userId={},userName={}",
                payload.getUserId(), payload.getTrailId());


        gameCenterService.upsertUserTrailId(payload.getUserId(), payload.getTrailId());
    }
}
