package com.course.project.gamecenter.domain.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
public class UserModeDAOTest {
    private UserModeDAO userModeDAO;

    @Before
    public void setUp() {
        userModeDAO = new UserModeDAO();
    }

    @Test
    public void testAddUserMode() {
        userModeDAO.addUserMode(999L, 4);
        assertEquals(Integer.valueOf(4), userModeDAO.getUserModeByUserId(999L));
    }

    @Test
    public void testContainUserMode() {
        assertTrue(userModeDAO.containUserMode(123L));
        assertFalse(userModeDAO.containUserMode(999L)); // Assuming user ID 999 does not exist initially
    }

    @Test
    public void testGetUserModeByUserId() {
        assertEquals(Integer.valueOf(1), userModeDAO.getUserModeByUserId(123L));
        assertEquals(Integer.valueOf(2), userModeDAO.getUserModeByUserId(456L));
        assertNull(userModeDAO.getUserModeByUserId(999L)); // Assuming user ID 999 does not exist initially
    }
}