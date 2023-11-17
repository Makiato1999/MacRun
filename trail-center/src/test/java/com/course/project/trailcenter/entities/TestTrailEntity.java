package com.course.project.trailcenter.entities;

import com.course.project.trailcenter.business.entities.TrailEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class TestTrailEntity {
    private TrailEntity trailEntity;
    private Long userId;
    private Integer trailId;
    private Integer trailRoute;
    private String trailName;
    private ArrayList<Integer> trailMap;
    private Random random = new Random();
    @Before
    public void init() {
        userId = random.nextLong();
        trailId = random.nextInt();
        trailRoute = random.nextInt(10);
        trailName = "The "+trailRoute+"th Campus Trail";
        trailMap = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            trailMap.add(random.nextInt(4));
        }
        trailEntity = new TrailEntity(userId, trailId, trailName, trailMap);
    }

    @Test
    public void testGetUserID_returnsCorrectUserID() {
        assertEquals(trailEntity.getUserId(), userId);
    }
    @Test
    public void testGetTrailID_returnsCorrectTrailID() {
        assertEquals(trailEntity.getTrailId(), trailId);
    }
    @Test
    public void testGetTrailName_returnsCorrectTrailName() {
        assertEquals(trailEntity.getTrailName(), trailName);
    }
    @Test
    public void testGetTrailMap_returnsCorrectTrailMap() {
        assertEquals(trailEntity.getTrailMap(), trailMap);
    }
    @Test
    public void testSetUserID_returnsCorrectUserID() {
        Long temp_userId = random.nextLong();
        trailEntity.setUserId(temp_userId);
        assertEquals(trailEntity.getUserId(), temp_userId);
    }
    @Test
    public void testSetTrailID_returnsCorrectTrailID() {
        Integer temp_trailId = random.nextInt();
        trailEntity.setTrailId(temp_trailId);
        assertEquals(trailEntity.getTrailId(), temp_trailId);
    }
    @Test
    public void testSetTrailName_returnsCorrectTrailName() {
        Integer temp_trailRoute = random.nextInt(10);
        String temp_trailName = "The "+temp_trailRoute+"th Campus Trail";
        trailEntity.setTrailName(temp_trailName);
        assertEquals(trailEntity.getTrailName(), temp_trailName);
    }
    @Test
    public void testSetTrailMap_returnsCorrectTrailMap() {
        ArrayList<Integer> temp_trailMap = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            temp_trailMap.add(random.nextInt(4));
        }
        trailEntity.setTrailMap(temp_trailMap);
        assertEquals(trailEntity.getTrailMap(), temp_trailMap);
    }
}
