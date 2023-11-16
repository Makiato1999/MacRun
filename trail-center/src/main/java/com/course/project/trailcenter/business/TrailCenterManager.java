package com.course.project.trailcenter.business;

import com.course.project.trailcenter.business.entities.TrailEntity;
import com.course.project.trailcenter.domain.producer.TrailCenterProducer;
import com.course.project.trailcenter.port.TrailCenterService;
import com.course.project.trailcenter.repository.TrailRepository;
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
    @Resource
    private TrailRepository trailRepository;

    @Override
    public TrailEntity allocate(Long userId, String longitude, String latitude) {
        TrailEntity trail = allocatePolicy(longitude, latitude);
        log.info("【Scenario2 - Trail_Center】-【Trail_Center】allocate trail, userId={},trailId={},trailName={}",
                userId, trail.getTrailId(), trail.getTrailName());

        trailRepository.addNewTrail(userId, trail.getTrailId(), trail.getTrailName(), trail.getTrailMap());

        log.info("【Scenario2 - Trail_Center】-【Trail_Center】send trail msg to 【Game Center】, userId={},trailId={},trailName={}",
                userId, trail.getTrailId(), trail.getTrailName());

        trail.setUserId(userId);

        // send mq to queue
        trailCenterProducer.sender(trail);

        return trail;
    }

    private TrailEntity allocatePolicy(String longitude, String latitude) {
        Random random = new Random();

        // allocate Trail ID
        Integer trailId = random.nextInt();
        // allocate Trail Name
        Integer trailRoute = random.nextInt(10);
        String trailName = "The " + trailRoute + "th Campus Trail";
        // allocate Trail map
        ArrayList<Integer> trailMap = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            trailMap.add(random.nextInt(4));
        }

        return TrailEntity.builder()
                .trailId(trailId)
                .trailName(trailName)
                .trailMap(trailMap)
                .build();
    }
}
