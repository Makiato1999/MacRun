package com.course.project.gamecenter.dto;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
public class GameAttackDataReqTest {

    @Test
    public void testNoArgsConstructor() {
        GameAttackDataReq request = new GameAttackDataReq();
        assertNull(request.getUserId());
        assertNull(request.getHeartRate());
        assertNull(request.getRecordDate());
    }

    @Test
    public void testAllArgsConstructor() {
        Date now = new Date();
        GameAttackDataReq request = new GameAttackDataReq(1L, 80, now);

        assertEquals(Long.valueOf(1L), request.getUserId());
        assertEquals(Integer.valueOf(80), request.getHeartRate());
        assertEquals(now, request.getRecordDate());
    }

    @Test
    public void testBuilder() {
        Date now = new Date();
        GameAttackDataReq request = GameAttackDataReq.builder()
                .userId(1L)
                .heartRate(80)
                .recordDate(now)
                .build();

        assertEquals(Long.valueOf(1L), request.getUserId());
        assertEquals(Integer.valueOf(80), request.getHeartRate());
        assertEquals(now, request.getRecordDate());
    }

    @Test
    public void testSettersAndGetters() {
        GameAttackDataReq request = new GameAttackDataReq();
        Date now = new Date();

        request.setUserId(1L);
        request.setHeartRate(80);
        request.setRecordDate(now);

        assertEquals(Long.valueOf(1L), request.getUserId());
        assertEquals(Integer.valueOf(80), request.getHeartRate());
        assertEquals(now, request.getRecordDate());
    }

}