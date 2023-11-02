package com.course.project.gamecenter.domain.repository;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserModeDAO {
    private static Map<Long, Integer> userModeMap = new HashMap<>();

    static {
        userModeMap.put(123L, 1);
        userModeMap.put(456L, 2);
        userModeMap.put(789L, 3);
    }

    public void addUserMode(Long userId, Integer userMode) {
        userModeMap.put(userId, userMode);
    }

    public Boolean containUserMode(Long userId) {
        return userModeMap.containsKey(userId);
    }

    public Integer getUserModeByUserId(Long userId) {
        return userModeMap.get(userId);
    }
}
