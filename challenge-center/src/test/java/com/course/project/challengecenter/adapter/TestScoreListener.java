package com.course.project.challengecenter.adapter;


import com.course.project.challengecenter.business.entity.Badges;
import com.course.project.challengecenter.business.entity.Profile;
import com.course.project.challengecenter.dto.ScoreReq;
import com.course.project.challengecenter.port.BadgesService;
import com.course.project.challengecenter.port.ProfileService;
import com.rabbitmq.client.Channel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class TestScoreListener {

    @Mock
    private ProfileService profileService;

    @Mock
    private BadgesService badgesService;

    @Mock
    private ScoreReq scoreReq;

    private ScoreListener scoreListener;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        scoreListener = new ScoreListener();
        scoreListener.profileService = profileService;
        scoreListener.badgesService = badgesService;
    }

    @Test
    public void testReceiveMsg() {
        when(badgesService.generateBadges(scoreReq)).thenReturn(new Badges());
        when(profileService.generateProfile(scoreReq)).thenReturn(new Profile());

        scoreListener.receiveMsg(scoreReq, mock(Channel.class), 1);

        verify(badgesService, times(1)).generateBadges(scoreReq);
        verify(profileService, times(1)).generateProfile(scoreReq);
    }
}
