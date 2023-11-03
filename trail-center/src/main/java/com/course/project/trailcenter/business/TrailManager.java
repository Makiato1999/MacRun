package com.course.project.trailcenter.business;

import com.course.project.trailcenter.business.entities.TrailEntity;
import com.course.project.trailcenter.port.TrailManagement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class TrailManager implements TrailManagement {
    @Override
    public TrailEntity create(Long userId, String longitude, String latitude) {

        return allocatePolicy(longitude, latitude);
    }

    private TrailEntity allocatePolicy(String longitude, String latitude) {
        //todo allocate trail logic
        return TrailEntity.builder()
                .trailId(new Random().nextInt())
                .trailName("trail allocation successfully!")
                .build();
    }
}
