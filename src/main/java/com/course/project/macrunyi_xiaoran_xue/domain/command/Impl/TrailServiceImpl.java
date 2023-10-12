package com.course.project.macrunyi_xiaoran_xue.domain.command.Impl;


import com.course.project.macrunyi_xiaoran_xue.domain.command.TrailService;
import com.course.project.macrunyi_xiaoran_xue.domain.entity.TrailEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TrailServiceImpl implements TrailService {

    @Override
    public TrailEntity allocateTrail(Long userId, String longitude, String latitude) {

        return allocatePolicy(longitude, latitude);
    }

    private TrailEntity allocatePolicy(String longitude, String latitude) {
        //todo allocate trail logic

        return TrailEntity.builder()
                .trailId(new Random().nextInt())
                .trailName("test trail")
                .build();
    }
}
