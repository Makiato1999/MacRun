package com.course.project.gamecenter.domain.repository;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserDataDAO {

    private static Map<Long, Integer> userDataMap = new HashMap<>();
    private static Map<Long, Integer> userHeartRate = new HashMap<>();

    static {
        userDataMap.put(123L, 10);
        userDataMap.put(456L, 20);
        userDataMap.put(789L, 30);
    }

    static {
        userHeartRate.put(123L, 90);
        userHeartRate.put(456L, 120);
        userHeartRate.put(789L, 150);
    }

    public Integer getScoreByUserId(Long userId) {
        return userDataMap.get(userId);
    }

    public void upsertScore(Long userId, Integer score) {
        userDataMap.put(userId, score);
    }

    public Integer getUserHearRate(Long userId) {
        return userHeartRate.get(userId);
    }

    public void upsertUserHeartRate(Long userId, Integer heartRate) {
        userHeartRate.put(userId, heartRate);
    }
}
