package com.course.project.gamecenter.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
public class CalculateUserScoreAlgorithmUtilsTest {

    @Test
    public void testCalculateUserScore() {
        CalculateUserScoreAlgorithmUtils utils = new CalculateUserScoreAlgorithmUtils();

        assertEquals(Integer.valueOf(10), utils.calculateUserScore(1L, 100));
        assertEquals(Integer.valueOf(5), utils.calculateUserScore(1L, 50));
    }

    @Test
    public void testCalculateUserScoreWithZeroHeartRate() {
        CalculateUserScoreAlgorithmUtils utils = new CalculateUserScoreAlgorithmUtils();

        assertEquals(Integer.valueOf(0), utils.calculateUserScore(1L, 0));
    }

    // Optional: Test for negative heart rates if applicable
    @Test
    public void testCalculateUserScoreWithNegativeHeartRate() {
        CalculateUserScoreAlgorithmUtils utils = new CalculateUserScoreAlgorithmUtils();

        assertEquals(Integer.valueOf(-5), utils.calculateUserScore(1L, -50));
    }

    // Optional: Test for null values if the method should handle them
    @Test(expected = NullPointerException.class)
    public void testCalculateUserScoreWithNullHeartRate() {
        CalculateUserScoreAlgorithmUtils utils = new CalculateUserScoreAlgorithmUtils();

        utils.calculateUserScore(1L, null);
    }
}