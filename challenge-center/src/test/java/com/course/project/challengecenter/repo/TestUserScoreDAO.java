package com.course.project.challengecenter.repo;

import com.course.project.challengecenter.dto.ScoreReq;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestUserScoreDAO {

    Long userId = 1L;
    private UserScoreDAO userScoreDAO;

    @Before
    public void setUp() {
        userScoreDAO = new UserScoreDAO();
    }

    @Test
    public void testContainUserName() {
        userScoreDAO.updateHighestScore(new ScoreReq(userId, 80));
        assertTrue(userScoreDAO.containUserName(userId));
    }

    @Test
    public void testUpdateHighestScore() {

        userScoreDAO.updateHighestScore(new ScoreReq(userId, 90));

        assertTrue(userScoreDAO.containUserName(userId));
        assertEquals(90, userScoreDAO.getHighestScoreByUserId(userId).intValue());

        userScoreDAO.updateHighestScore(new ScoreReq(userId, 85));

        assertEquals(90, userScoreDAO.getHighestScoreByUserId(userId).intValue());
    }

    @Test
    public void testGetHighestScoreByUserId() {
        assertEquals(90, userScoreDAO.getHighestScoreByUserId(userId).intValue());
    }


}
