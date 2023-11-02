package com.course.project.gamecenter.utils;

import org.springframework.stereotype.Component;

@Component
public class CalculateUserScoreAlgorithmUtils {

    public Integer calculateUserScore(Long userId, Integer heartRate) {

        return heartRate / 10;
    }
}
