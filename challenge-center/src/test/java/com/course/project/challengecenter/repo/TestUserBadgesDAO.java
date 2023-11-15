package com.course.project.challengecenter.repo;

import com.course.project.challengecenter.business.entity.Badges;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class TestUserBadgesDAO {

    private UserBadgesDAO userBadgesDAO;

    @Before
    public void setUp() {
        userBadgesDAO = new UserBadgesDAO();
    }

    @Test
    public void testContainUserName() {
        Long userId = 1L;
        Long badgeId = 123L;

        assertFalse(userBadgesDAO.containUserName(userId));

        userBadgesDAO.createBadges(userId, new Badges(badgeId, userId, "Advanced Badges", LocalDateTime.now()));
        assertTrue(userBadgesDAO.containUserName(userId));
    }

    @Test
    public void testCreateBadges() {
        Long userId = 2L;
        Long badgeId = 456L;
        Badges badge = new Badges(badgeId, userId, "Intermedia Badges", LocalDateTime.now());

        userBadgesDAO.createBadges(userId, badge);

        assertTrue(userBadgesDAO.containUserName(userId));
        List<Badges> badgesList = userBadgesDAO.getBadgesByUserId(userId);
        assertNotNull(badgesList);
        assertEquals(1, badgesList.size());
        assertEquals(badge, badgesList.get(0));

        userBadgesDAO.createBadges(userId, badge);

        badgesList = userBadgesDAO.getBadgesByUserId(userId);
        assertNotNull(badgesList);
        assertEquals(1, badgesList.size());
    }

    @Test
    public void testGetBadgesByUserId() {
        Long userId = 3L;
        Long badgeId1 = 456L;
        Long badgeId2 = 789L;
        Badges badge1 = new Badges(badgeId1, userId, "Intermedia Badges", LocalDateTime.now());
        Badges badge2 = new Badges(badgeId2, userId, "Advanced Badges", LocalDateTime.now());

        userBadgesDAO.createBadges(userId, badge1);
        userBadgesDAO.createBadges(userId, badge2);

        List<Badges> badgesList = userBadgesDAO.getBadgesByUserId(userId);
        assertNotNull(badgesList);
        assertEquals(2, badgesList.size());
        assertTrue(badgesList.contains(badge1));
        assertTrue(badgesList.contains(badge2));
    }

}
