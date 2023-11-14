package com.course.project.gamecenter.dto;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
public class GameAttackReqTest {

    @Test
    public void testNoArgsConstructor() {
        GameAttackReq request = new GameAttackReq();
        assertNull(request.getUserId());
        assertNull(request.getLongitude());
        assertNull(request.getLatitude());
        assertNull(request.getHeartRateCnt());
    }

    @Test
    public void testAllArgsConstructor() {
        GameAttackReq request = new GameAttackReq(1L, 100L, 200L, 80);

        assertEquals(Long.valueOf(1L), request.getUserId());
        assertEquals(Long.valueOf(100L), request.getLongitude());
        assertEquals(Long.valueOf(200L), request.getLatitude());
        assertEquals(Integer.valueOf(80), request.getHeartRateCnt());
    }

    @Test
    public void testBuilder() {
        GameAttackReq request = GameAttackReq.builder()
                .userId(1L)
                .longitude(100L)
                .latitude(200L)
                .heartRateCnt(80)
                .build();

        assertEquals(Long.valueOf(1L), request.getUserId());
        assertEquals(Long.valueOf(100L), request.getLongitude());
        assertEquals(Long.valueOf(200L), request.getLatitude());
        assertEquals(Integer.valueOf(80), request.getHeartRateCnt());
    }

    @Test
    public void testSettersAndGetters() {
        GameAttackReq request = new GameAttackReq();
        request.setUserId(1L);
        request.setLongitude(100L);
        request.setLatitude(200L);
        request.setHeartRateCnt(80);

        assertEquals(Long.valueOf(1L), request.getUserId());
        assertEquals(Long.valueOf(100L), request.getLongitude());
        assertEquals(Long.valueOf(200L), request.getLatitude());
        assertEquals(Integer.valueOf(80), request.getHeartRateCnt());
    }

}