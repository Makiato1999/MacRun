package com.course.project.gamecenter.dto;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
public class GamePlayReqTest {
    @Test
    public void testNoArgsConstructor() {
        GamePlayReq request = new GamePlayReq();
        assertNull(request.getUserId());
        assertNull(request.getAttackId());
        assertNull(request.getLongitude());
        assertNull(request.getLatitude());
        assertNull(request.getHeartRateCnt());
    }

    @Test
    public void testAllArgsConstructor() {
        GamePlayReq request = new GamePlayReq(1L, 101, 100L, 200L, 80);

        assertEquals(Long.valueOf(1L), request.getUserId());
        assertEquals(Integer.valueOf(101), request.getAttackId());
        assertEquals(Long.valueOf(100L), request.getLongitude());
        assertEquals(Long.valueOf(200L), request.getLatitude());
        assertEquals(Integer.valueOf(80), request.getHeartRateCnt());
    }

    @Test
    public void testBuilder() {
        GamePlayReq request = GamePlayReq.builder()
                .userId(1L)
                .attackId(101)
                .longitude(100L)
                .latitude(200L)
                .heartRateCnt(80)
                .build();

        assertEquals(Long.valueOf(1L), request.getUserId());
        assertEquals(Integer.valueOf(101), request.getAttackId());
        assertEquals(Long.valueOf(100L), request.getLongitude());
        assertEquals(Long.valueOf(200L), request.getLatitude());
        assertEquals(Integer.valueOf(80), request.getHeartRateCnt());
    }

    @Test
    public void testSettersAndGetters() {
        GamePlayReq request = new GamePlayReq();
        request.setUserId(1L);
        request.setAttackId(101);
        request.setLongitude(100L);
        request.setLatitude(200L);
        request.setHeartRateCnt(80);

        assertEquals(Long.valueOf(1L), request.getUserId());
        assertEquals(Integer.valueOf(101), request.getAttackId());
        assertEquals(Long.valueOf(100L), request.getLongitude());
        assertEquals(Long.valueOf(200L), request.getLatitude());
        assertEquals(Integer.valueOf(80), request.getHeartRateCnt());
    }
}