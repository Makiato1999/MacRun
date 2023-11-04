package com.course.project.challengecenter.adapter;

import com.course.project.challengecenter.RabbitConfiguration;
import com.course.project.challengecenter.business.entity.Badges;
import com.course.project.challengecenter.business.entity.Profile;
import com.course.project.challengecenter.dto.ScoreReq;
import com.course.project.challengecenter.port.BadgesService;
import com.course.project.challengecenter.port.ProfileService;
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
    @Resource
    private BadgesService badgesService;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = RabbitConfiguration.QUEUE_NAME_SCORE, durable = "true"),
                    exchange = @Exchange(value = RabbitConfiguration.EXCHANGE_NAME_SCORE, ignoreDeclarationExceptions = "true"),
                    key = RabbitConfiguration.ROUTING_KEY_SCORE))
    // get other info to generate profile/badges?
    public void receiveMsg(ScoreReq payload, Channel channel,
                           @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        log.info("receive message: '" + payload + "'");
        if (payload == null) {
            return;
        }


        Badges badges = badgesService.genereateBadges(payload);
        Profile profile = profileService.genereateProfile(payload);
        log.info("Congratulations, you get this new badges: '" + badges + "'");
        log.info("Profile: '" + profile + "'");


    }

}
