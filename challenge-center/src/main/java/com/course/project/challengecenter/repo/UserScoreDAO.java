package com.course.project.challengecenter.repo;

import com.course.project.challengecenter.dto.ScoreReq;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserScoreDAO {

    private static Map<Long, Integer> userScoreMap = new HashMap<>();


    public Boolean containUserName(Long userId) {
        return userScoreMap.containsKey(userId);
    }

    public void updateHighestScore(ScoreReq userinfo) {
        Long userId = userinfo.getUserId();
        Integer score = userinfo.getScore();
        if (!containUserName(userId)) {
            userScoreMap.put(userId, score);
        } else {
            Integer originScore = userScoreMap.get(userId);
            if (originScore < score) {
                userScoreMap.put(userId, score);
            }
        }
    }

    public Integer getHighestScoreByUserId(Long userId) {
        return userScoreMap.get(userId);
    }

}
