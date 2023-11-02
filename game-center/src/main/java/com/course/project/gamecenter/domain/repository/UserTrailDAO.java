package com.course.project.gamecenter.domain.repository;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserTrailDAO {

    private static Map<Long, Integer> userTrailMap = new HashMap<>();

    static {
        userTrailMap.put(123L, 1);
        userTrailMap.put(456L, 2);
        userTrailMap.put(789L, 3);
    }

    public void upsertUserTrailId(Long userId, Integer trailId) {
        userTrailMap.put(userId, trailId);
    }

    public Boolean containUserTrail(Long userId) {
        return userTrailMap.containsKey(userId);
    }

    public Integer getTrailIdByUserId(Long userId) {
        return userTrailMap.get(userId);
    }

    public List<Integer> getTrailListModeByTrailId(Integer trailId) {
        return Arrays.asList(1, 1, 2, 3, 1, 1, 3);
    }
}
