package com.course.project.trailcenter.finders;

import com.course.project.trailcenter.business.TrailCenterManager;
import com.course.project.trailcenter.business.entities.TrailEntity;
import com.course.project.trailcenter.port.TrailCenterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestTrailCenterService {
    private Long userId;
    private String longitude;
    private String latitude;
    private Integer trailId;
    private String trailName;
    private ArrayList<Integer> trailMap;
    private TrailEntity trailEntity;
    private Random random = new Random();

    @TestConfiguration
    static class TestTrailCenterServiceContextConfiguration {
        @Bean
        public TrailCenterService trailCenterManager() {
            return new TrailCenterManager();
        }
    }
    @Mock
    private TrailCenterService trailCenterService;

    @Before
    public void init() {
        userId = random.nextLong();
        longitude = "45.6789";
        latitude = "12.3456";

        userId = random.nextLong();
        trailId = random.nextInt();
        Integer trailRoute = random.nextInt(10);
        trailName = "The "+trailRoute+"th Campus Trail";
        trailMap = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            trailMap.add(random.nextInt(4));
        }
        trailEntity = new TrailEntity(userId, trailId, trailName, trailMap);

        Mockito.when(trailCenterService.allocate(userId, longitude, latitude)).
                thenReturn(trailEntity);
    }

    @Test
    public void testTrailAllocation_returnsCorrectTrailAllocation() {
        TrailEntity trail = trailCenterService.allocate(userId, longitude, latitude);

        assertEquals(trail.getUserId(), userId);
        assertEquals(trail.getTrailId(), trailId);
        assertEquals(trail.getTrailName(), trailName);
        assertEquals(trail.getTrailMap(), trailMap);
    }
}
