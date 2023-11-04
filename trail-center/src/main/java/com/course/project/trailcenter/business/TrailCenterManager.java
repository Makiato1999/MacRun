package com.course.project.trailcenter.business;

import com.course.project.trailcenter.business.entities.TrailEntity;
import com.course.project.trailcenter.domain.producer.TrailCenterProducer;
import com.course.project.trailcenter.port.TrailCenterService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
@Slf4j
public class TrailCenterManager implements TrailCenterService {
    @Resource
    private TrailCenterProducer trailCenterProducer;

    @Override
    public TrailEntity allocate(Long userId, String longitude, String latitude) {

        return allocatePolicy(longitude, latitude);
    }

    private TrailEntity allocatePolicy(String longitude, String latitude) {
        // allocate trail logic (not finished)
        ArrayList<Integer> trailMap = new ArrayList<>(100);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            trailMap.add(random.nextInt(4));
        }
        int trailId = random.nextInt();
        String trailName = "random trail allocation";
        System.out.println("\ntrailId: " + trailId + ", trailName: " + trailName + ", trailMap: " + trailMap);
        return TrailEntity.builder()
                .trailId(trailId)
                .trailName(trailName)
                .trailMap(trailMap)
                .build();
    }

    @Override
    public void sendTrail(TrailEntity trail) {
        trailCenterProducer.sendTrail(trail);
    }
}
