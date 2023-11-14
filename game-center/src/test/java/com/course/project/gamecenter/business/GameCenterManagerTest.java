package com.course.project.gamecenter.business;

import com.course.project.gamecenter.business.entity.GameAttachDataEntity;
import com.course.project.gamecenter.business.entity.GameAttackEntity;
import com.course.project.gamecenter.business.entity.GamePlayEntity;
import com.course.project.gamecenter.domain.events.producer.UserScoreProducer;
import com.course.project.gamecenter.domain.repository.UserDataDAO;
import com.course.project.gamecenter.domain.repository.UserModeDAO;
import com.course.project.gamecenter.domain.repository.UserTrailDAO;
import com.course.project.gamecenter.dto.GameAttackDataReq;
import com.course.project.gamecenter.dto.GameAttackReq;
import com.course.project.gamecenter.dto.GamePlayReq;
import com.course.project.gamecenter.enums.AttackEnum;
import com.course.project.gamecenter.utils.AttackUserAlgorithmUtils;
import com.course.project.gamecenter.utils.CalculateUserScoreAlgorithmUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@Slf4j
@SpringBootTest
public class GameCenterManagerTest {

    @Mock
    private UserTrailDAO userTrailDAO;
    @Mock
    private UserModeDAO userModeDAO;
    @Mock
    private UserDataDAO userDataDAO;
    @Mock
    private AttackUserAlgorithmUtils attackUserAlgorithmUtils;
    @Mock
    private CalculateUserScoreAlgorithmUtils calculateUserScoreAlgorithmUtils;
    @Mock
    private UserScoreProducer userScoreProducer;
    @InjectMocks
    private GameCenterManager gameCenterManager;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPlay() {
        // Arrange
        GamePlayReq req = new GamePlayReq();
        req.setUserId(1L);
        req.setAttackId(101);
        when(userDataDAO.getUserHearRate(1L)).thenReturn(80);

        // Act
        GamePlayEntity result = gameCenterManager.play(req);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getUserId().longValue());
        // More assertions based on expected behavior
    }

    @Test
    public void testGenerateAttackModeWithValidData() {
        // Arrange
        GameAttackReq req = new GameAttackReq();
        req.setUserId(1L);
        req.setLongitude(100L);
        req.setLatitude(50L);
        when(userTrailDAO.getTrailIdByUserId(1L)).thenReturn(10);
        when(attackUserAlgorithmUtils.getAttackMethod(anyLong(), anyInt(), anyLong(), anyLong(), anyList()))
                .thenReturn(AttackEnum.DO_NOT_ATTACK);

        // Act
        GameAttackEntity result = gameCenterManager.generateAttackMode(req);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getUserId().longValue());
        // Other assertions...
    }

    @Test
    public void testGenerateAttackModeWithInvalidUserId() {
        // Arrange
        GameAttackReq req = new GameAttackReq();
        req.setUserId(null);

        // Act
        GameAttackEntity result = gameCenterManager.generateAttackMode(req);

        // Assert
        assertNull(result);
    }

    @Test
    public void testCalculateScore() {
        // Arrange
        GameAttackDataReq req = new GameAttackDataReq();
        req.setUserId(1L);
        req.setHeartRate(80);
        when(calculateUserScoreAlgorithmUtils.calculateUserScore(1L, 80)).thenReturn(100);

        // Act
        GameAttachDataEntity result = gameCenterManager.calculateScore(req);

        // Assert
        assertNotNull(result);
        assertEquals(100, result.getScore().intValue());
        verify(userDataDAO, times(1)).upsertScore(1L, 100);
        // Other assertions...
    }
}