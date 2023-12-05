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
    public TrailEntity findTrailAllocation(Long userId) {
        String longitude = generateRandomCoordinates()[0];
        String latitude = generateRandomCoordinates()[1];

        TrailEntity trail = allocatePolicy(longitude, latitude);
        trail.setUserId(userId);
        /*
        log.info("【Scenario201 - TrailCenter】-【TrailCenter】allocate trail, userId={},trailId={},trailName={}",
                userId, trail.getTrailId(), trail.getTrailName());

        trailRepository.addNewTrail(userId, trail.getTrailId(), trail.getTrailName(), trail.getTrailMap());

        log.info("【Scenario201 - TrailCenter】-【TrailCenter】send trail msg to【GameCenter】, userId={},trailId={},trailName={}",
                userId, trail.getTrailId(), trail.getTrailName());

        trail.setUserId(userId);

        // send mq to queue
        trailCenterProducer.sender(trail);

         */

        return trail;
    }
    @Override
    public TrailEntity setTrailAllocation(Long userId, String longitude, String latitude) {
        TrailEntity trail = allocatePolicy(longitude, latitude);
        log.info("【Scenario201 - TrailCenter】-【TrailCenter】allocate trail, userId={},trailId={},trailName={}",
                userId, trail.getTrailId(), trail.getTrailName());

        trailRepository.addNewTrail(userId, trail.getTrailId(), trail.getTrailName(), trail.getTrailMap());

        log.info("【Scenario201 - TrailCenter】-【TrailCenter】send trail msg to【GameCenter】, userId={},trailId={},trailName={}",
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

    private String[] generateRandomCoordinates() {
        Random random = new Random();

        // Latitude ranges from -90 to 90
        double latitude = -90 + random.nextDouble() * 180;

        // Longitude ranges from -180 to 180
        double longitude = -180 + random.nextDouble() * 360;

        // Formatting to strings with 6 decimal places
        String latitudeStr = String.format("%.6f", latitude);
        String longitudeStr = String.format("%.6f", longitude);

        return new String[] {latitudeStr, longitudeStr};
    }
}
