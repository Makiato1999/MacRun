package com.course.project.challengecenter.business;

import com.course.project.challengecenter.business.entity.Badges;
import com.course.project.challengecenter.dto.ScoreReq;
import com.course.project.challengecenter.repo.UserBadgesDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestBadgesManager {

    @Mock
    private UserBadgesDAO userBadgesDAO;

    @InjectMocks
    private BadgesManager badgesManager;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGenerateBadges() {
        ScoreReq scoreReq = new ScoreReq();
        scoreReq.setUserId(1L);
        scoreReq.setScore(95);

        Random random = mock(Random.class);
        when(random.nextLong()).thenReturn(123L);

        badgesManager = new BadgesManager();
        badgesManager.userBadgesDAO = userBadgesDAO;

        Badges badges = badgesManager.generateBadges(scoreReq);


        verify(userBadgesDAO, times(1)).createBadges(eq(1L), any(Badges.class));
        assertEquals(1L, badges.getUserId().longValue());
        assertEquals("Advanced Badge", badges.getName());
        assertEquals(scoreReq.getUserId(), badges.getUserId());
        assertEquals(LocalDateTime.now().getDayOfYear(), badges.getCreateDate().getDayOfYear()); // Ignoring time for simplicity
    }

    @Test
    public void testGenerateBadgesWithNullUserId() {

        ScoreReq scoreReq = new ScoreReq();
        scoreReq.setUserId(null);
        scoreReq.setScore(95);

        Badges badges = badgesManager.generateBadges(scoreReq);

        verify(userBadgesDAO, never()).createBadges(anyLong(), any(Badges.class));
        assertEquals(null, badges);
    }

}
