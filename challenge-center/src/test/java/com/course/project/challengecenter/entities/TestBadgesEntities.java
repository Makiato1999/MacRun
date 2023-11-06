package com.course.project.challengecenter.entities;

import com.course.project.challengecenter.business.BadgesManager;
import com.course.project.challengecenter.business.entity.Badges;
import com.course.project.challengecenter.dto.ScoreReq;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
@Slf4j
public class TestBadgesEntities {

    private Badges badges = new Badges();
    private Long userId;
    private Integer score;
    private LocalDateTime dateTime;


    @Before
    public void init() {


        BadgesManager badgesManager = new BadgesManager();
        userId = new Random().nextLong();
        score = new Random().nextInt(99);
        dateTime = LocalDateTime.now();

        badges = badgesManager.generateBadges(new ScoreReq(userId, score));

    }

    @Test
    public void testGetUser_returnsCorrectUser() {
        if (badges != null) {
            assertEquals(badges.getUserId(), userId);
        }
    }

    @Test
    public void testGetDateTime_returnsCorrectDateTime() {
        if (badges != null) {
            Duration difference = Duration.between(badges.getCreateDate(), dateTime).abs();
            Duration tolerance = Duration.ofSeconds(10);
            assertTrue(difference.compareTo(tolerance) <= 0);
        }
    }

    @Test
    public void testGetBadgesName_returnsCorrectName() {
        if (score >= 90) {
            assertEquals(badges.getName(), "Advanced Badge");
        } else if (score >= 80 && score < 90) {
            assertEquals(badges.getName(), "Intermedia Badge");
        } else if (score >= 70 && score < 80) {
            assertEquals(badges.getName(), "Starter Badge");
        }
    }


}
