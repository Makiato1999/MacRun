package com.course.project.gamecenter.adapters;

import com.course.project.gamecenter.adapters.resp.Response;
import com.course.project.gamecenter.business.entity.GamePlayEntity;
import com.course.project.gamecenter.dto.GamePlayReq;
import com.course.project.gamecenter.port.GameCenterService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Xiaoran changed url as 'http://localhost:8762/game/action'
 */
@RestController
@RequestMapping("game")
@Slf4j
public class GameCenterController {

    @Resource
    private GameCenterService gameCenterService;


    @RequestMapping(value = "action", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response<GamePlayEntity> userReact(@RequestBody GamePlayReq gamePlayEntity) {

        log.info("【Scenario303 - GameCenter】-【GameCenter】User start play, userId={},attackId={}", gamePlayEntity.getUserId(), gamePlayEntity.getAttackId());

        GamePlayReq gamePlayReq = GamePlayReq.builder()
                .userId(gamePlayEntity.getUserId())
                .attackId(gamePlayEntity.getAttackId())
                .build();
        GamePlayEntity res = gameCenterService.play(gamePlayReq);
        return Response.success(res);
    }

}

/*
@RestController
@RequestMapping(produces = "application/json")
@Slf4j
public class GameCenterController {
    private static final String ENDPOINT = "/game";

    @Resource
    private GameCenterService gameCenterService;

    @PostMapping(ENDPOINT + "/action")
    public GamePlayEntity userReact(@RequestBody GamePlayReq gamePlayEntity) {
        log.info("【Scenario303 - GameCenter】-【GameCenter】User start play, userId={},attackId={}", gamePlayEntity.getUserId(), gamePlayEntity.getAttackId());
        GamePlayReq gamePlayReq = GamePlayReq.builder()
                .userId(gamePlayEntity.getUserId())
                .attackId(gamePlayEntity.getAttackId())
                .build();
        GamePlayEntity res = gameCenterService.play(gamePlayReq);
        return Response.success(res).getData();
    }
}

 */
