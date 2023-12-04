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
    public ProfileService profileService;
    @Resource
    public BadgesService badgesService;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = RabbitConfiguration.QUEUE_NAME_SCORE, durable = "true"),
                    exchange = @Exchange(value = RabbitConfiguration.EXCHANGE_NAME_SCORE, ignoreDeclarationExceptions = "true"),
                    key = RabbitConfiguration.ROUTING_KEY_SCORE))
    public void receiveMsg(ScoreReq payload, Channel channel,
                           @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
//        "update user and trailId relation to db, userId={},trailId={},", userId, trailId)
        if (payload == null) {
            return;
        }
        log.info("【Scenario501 - ChallengeCenter】-【ChallengeCenter】Receive message from【GameCenter】. Receive userId = {},trailId = {}", payload.getUserId(), payload.getScore());



        Badges badges = badgesService.generateBadges(payload);
        Profile profile = profileService.generateProfile(payload);
        if (badges != null) {
            log.info("Congratulations, user {}, you get the {} at {}", badges.getUserId(), badges.getName(), badges.getCreateDate());
        }
        log.info("Profile: user = {}, highest score = {}, badges = {}", profile.getUserId(), profile.getHighestScore(), profile.getBadges());


    }

}
