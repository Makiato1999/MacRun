package com.course.project.challengecenter.port;

import com.course.project.challengecenter.business.entity.Badges;
import com.course.project.challengecenter.dto.ScoreReq;

public interface BadgesService {

    Badges genereateBadges(ScoreReq userinfo);

}
