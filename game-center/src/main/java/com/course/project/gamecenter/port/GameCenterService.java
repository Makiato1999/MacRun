package com.course.project.gamecenter.port;

import com.course.project.gamecenter.business.entity.GameAttachDataEntity;
import com.course.project.gamecenter.business.entity.GameAttackEntity;
import com.course.project.gamecenter.business.entity.GamePlayEntity;
import com.course.project.gamecenter.dto.GameAttackDataReq;
import com.course.project.gamecenter.dto.GameAttackReq;
import com.course.project.gamecenter.dto.GamePlayReq;

public interface GameCenterService {

    /**
     * USER INTERACT TO THE SYSTEM
     *
     * @param req
     * @return
     */
    GamePlayEntity play(GamePlayReq req);

    /**
     * SYSTEM GENERATE ATTACK
     *
     * @param req
     * @return
     */
    GameAttackEntity generateAttackMode(GameAttackReq req);

    GameAttachDataEntity calculateScore(GameAttackDataReq req);

    void addUserMode(Long userId, Integer userMode);

    void upsertUserTrailId(Long userId, Integer trailId);
}
