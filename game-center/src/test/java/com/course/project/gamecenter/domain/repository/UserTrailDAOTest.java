package com.course.project.gamecenter.domain.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
public class UserTrailDAOTest {

    private UserTrailDAO userTrailDAO;

    @Before
    public void setUp() {
        userTrailDAO = new UserTrailDAO();
    }

    @Test
    public void testUpsertUserTrailId() {
        userTrailDAO.upsertUserTrailId(999L, 4);
        assertEquals(Integer.valueOf(4), userTrailDAO.getTrailIdByUserId(999L));
    }

    @Test
    public void testContainUserTrail() {
        assertTrue(userTrailDAO.containUserTrail(123L));
        assertFalse(userTrailDAO.containUserTrail(999L)); // Assuming user ID 999 does not exist initially
    }

    @Test
    public void testGetTrailIdByUserId() {
        assertEquals(Integer.valueOf(1), userTrailDAO.getTrailIdByUserId(123L));
        assertEquals(Integer.valueOf(2), userTrailDAO.getTrailIdByUserId(456L));
        assertNull(userTrailDAO.getTrailIdByUserId(999L)); // Assuming user ID 999 does not exist initially
    }

    @Test
    public void testGetTrailListModeByTrailId() {
        List<Integer> expectedList = Arrays.asList(1, 1, 2, 3, 1, 1, 3);
        assertEquals(expectedList, userTrailDAO.getTrailListModeByTrailId(1));
        // Note: This method always returns the same list, irrespective of the trailId provided
    }
}