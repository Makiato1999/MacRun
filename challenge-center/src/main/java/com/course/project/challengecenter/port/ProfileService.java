package com.course.project.challengecenter.port;

import com.course.project.challengecenter.business.entity.Badges;
import com.course.project.challengecenter.business.entity.Profile;
import com.course.project.challengecenter.dto.ScoreReq;
import com.course.project.gamecenter.business.entity.GameAttachDataEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;


public interface ProfileService {


    Badges genereateBadges(ScoreReq userinfo);

    Profile genereateProfile(ScoreReq userinfo);




}
