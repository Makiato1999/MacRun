package com.course.project.challengecenter.business;

import com.course.project.challengecenter.business.entity.Badges;
import com.course.project.challengecenter.business.entity.Profile;
import com.course.project.challengecenter.dto.ScoreReq;
import com.course.project.challengecenter.repo.UserBadgesDAO;
import com.course.project.challengecenter.repo.UserScoreDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestProfileManager {

    @Mock
    private UserBadgesDAO userBadgesDAO;


    @Mock
    private UserScoreDAO userScoreDAO;


    @InjectMocks
    private BadgesManager badgesManager;

    @InjectMocks
    private ProfileManager profileManager;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGenerateProfile() {
        ScoreReq scoreReq_A = new ScoreReq();
        scoreReq_A.setUserId(1L);
        scoreReq_A.setScore(95);

        ScoreReq scoreReq_I = new ScoreReq();
        scoreReq_I.setUserId(1L);
        scoreReq_I.setScore(85);
        badgesManager = new BadgesManager();
        badgesManager.userBadgesDAO = userBadgesDAO;

        List<Badges> badgesList = Arrays.asList(
                badgesManager.generateBadges(scoreReq_A),
                badgesManager.generateBadges(scoreReq_I));

        when(userBadgesDAO.containUserName(1L)).thenReturn(true);
        when(userBadgesDAO.getBadgesByUserId(1L)).thenReturn(badgesList);

        when(userScoreDAO.containUserName(1L)).thenReturn(true);
        when(userScoreDAO.getHighestScoreByUserId(1L)).thenReturn(95);

        Profile profile = profileManager.generateProfile(scoreReq_A);

        assertEquals(1L, profile.getUserId().longValue());
        assertEquals(95, profile.getHighestScore().intValue());
        assertEquals(badgesList, profile.getBadges());

        verify(userBadgesDAO, times(1)).getBadgesByUserId(1L);
        verify(userScoreDAO, times(1)).containUserName(1L);
        verify(userScoreDAO, times(1)).getHighestScoreByUserId(1L);
    }

}
