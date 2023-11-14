package com.course.project.gamecenter.domain.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
public class UserDataDAOTest {
    private UserDataDAO userDataDAO;

    @Before
    public void setUp() {
        userDataDAO = new UserDataDAO();
    }

    @Test
    public void testGetScoreByUserId() {
        assertEquals(Integer.valueOf(10), userDataDAO.getScoreByUserId(123L));
        assertEquals(Integer.valueOf(20), userDataDAO.getScoreByUserId(456L));
        assertNull(userDataDAO.getScoreByUserId(999L)); // Assuming user ID 999 does not exist
    }

    @Test
    public void testUpsertScore() {
        userDataDAO.upsertScore(123L, 40);
        assertEquals(Integer.valueOf(40), userDataDAO.getScoreByUserId(123L));

        // Test inserting a new score
        userDataDAO.upsertScore(999L, 50);
        assertEquals(Integer.valueOf(50), userDataDAO.getScoreByUserId(999L));
    }

    @Test
    public void testGetUserHeartRate() {
        assertEquals(Integer.valueOf(90), userDataDAO.getUserHearRate(123L));
        assertEquals(Integer.valueOf(120), userDataDAO.getUserHearRate(456L));
        assertNull(userDataDAO.getUserHearRate(999L)); // Assuming user ID 999 does not exist
    }

    @Test
    public void testUpsertUserHeartRate() {
        userDataDAO.upsertUserHeartRate(123L, 160);
        assertEquals(Integer.valueOf(160), userDataDAO.getUserHearRate(123L));

        // Test inserting a new heart rate
        userDataDAO.upsertUserHeartRate(999L, 100);
        assertEquals(Integer.valueOf(100), userDataDAO.getUserHearRate(999L));
    }
}