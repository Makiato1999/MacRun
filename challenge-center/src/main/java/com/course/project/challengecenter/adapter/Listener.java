package com.course.project.challengecenter.adapter;

import com.course.project.challengecenter.RabbitConfiguration;
import com.course.project.challengecenter.business.ListeningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@Slf4j
public class Listener {
    private final ListeningService tracker;

    @Autowired
    public Listener(ListeningService tracker) {
        this.tracker = tracker;
        log.info("Set up RabbitMQ listener");
    }

    // tell Java to listen to the RabbitMQ queue and call it should a message be received
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = RabbitConfiguration.QUEUE_HELLO_WORLD, durable = "true"),
            exchange = @Exchange(
                    value = RabbitConfiguration.EXCHANGE_NAME),
            key = RabbitConfiguration.ROUTING_HELLO_WORLD))

    // Write your function here
    public void receive(String msg) {
        log.info("Got message: '" + msg + "'");
    }

}
