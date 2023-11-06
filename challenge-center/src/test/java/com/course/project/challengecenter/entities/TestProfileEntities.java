package com.course.project.challengecenter.entities;


import com.course.project.challengecenter.business.BadgesManager;
import com.course.project.challengecenter.business.ProfileManager;
import com.course.project.challengecenter.business.entity.Badges;
import com.course.project.challengecenter.business.entity.Profile;
import com.course.project.challengecenter.dto.ScoreReq;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Component
@Slf4j
public class TestProfileEntities {


    private static Long userId;
    private static List<Badges> badges = new ArrayList<>();

    private static Badges badge = new Badges();
    private static Profile profile;
    static List<Integer> scores;

    @BeforeClass
    public static void init() {


        BadgesManager badgesManager = new BadgesManager();

        ProfileManager profileManager = new ProfileManager();
        userId = new Random().nextLong();
        Random random = new Random();

        // Create a list of scores
        scores = new ArrayList<>();

        // Add random scores to the list
        for (int i = 0; i < 10; i++) {
            // Generate a random score between 0 and 100
            int score = random.nextInt(99);
            scores.add(score);
            badge = badgesManager.generateBadges(new ScoreReq(userId, score));
            // Get list of badges name and add it to list
            List<String> badgesName = badges.stream()
                    .map(Badges::getName)
                    .toList();
            if (badge != null && !badgesName.contains(badge.getName())) {
                badges.add(badge);
            }
            profile = profileManager.generateProfile(new ScoreReq(userId, score));
        }
    }

    @Test
    public void testGetUser_returnsCorrectUser() {
        Assertions.assertEquals(profile.getUserId(), userId);
    }

    @Test
    public void testGetHighestScore_returnsCorrectScore() {
        Assertions.assertEquals(profile.getHighestScore(), Collections.max(scores));
    }


    @Test
    public void testGetBadgesList_returnsCorrectBadgesList() {
        assertEquals(profile.getBadges(), badges);
    }


}
