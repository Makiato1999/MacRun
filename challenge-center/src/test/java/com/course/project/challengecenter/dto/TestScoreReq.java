package com.course.project.challengecenter.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestScoreReq {

    @Test
    public void testScoreReqConstructor() {
        Long userId = 123L;
        Integer score = 80;

        ScoreReq scoreReq = new ScoreReq(userId, score);

        assertEquals(userId, scoreReq.getUserId());
        assertEquals(score, scoreReq.getScore());
    }

    @Test
    public void testScoreReqDefaultConstructor() {
        ScoreReq scoreReq = new ScoreReq();

        assertEquals(null, scoreReq.getUserId());
        assertEquals(null, scoreReq.getScore());
    }

    @Test
    public void testScoreReqBuilder() {
        Long userId = 456L;
        Integer score = 95;

        ScoreReq scoreReq = ScoreReq.builder()
                .userId(userId)
                .score(score)
                .build();

        assertEquals(userId, scoreReq.getUserId());
        assertEquals(score, scoreReq.getScore());
    }

}
