package com.course.project.gamecenter.utils;

import com.course.project.gamecenter.enums.AttackEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class AttackUserAlgorithmUtils {

    public AttackEnum getAttackMethod(Long userId, Integer gameMode, Long longitude,
                                      Long latitude, List<Integer> trailPlayList) {
        Integer playMode = new Random().nextInt(3);
        return AttackEnum.getEnumById(playMode);
    }
}
