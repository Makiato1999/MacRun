package com.course.project.challengecenter.business;

import com.course.project.challengecenter.business.entity.Badges;
import com.course.project.challengecenter.business.entity.Profile;
import com.course.project.challengecenter.dto.ScoreReq;
import com.course.project.challengecenter.port.ProfileService;
import com.course.project.challengecenter.repo.UserBadgesDAO;
import com.course.project.challengecenter.repo.UserScoreDAO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

@Service
public class ProfileManager implements ProfileService {

    @Resource
    private UserBadgesDAO userBadgesDAO;

    @Resource
    private UserScoreDAO userScoreDAO;

    @Override
    public Badges genereateBadges(ScoreReq userinfo) {

        Long id = new Random().nextLong();
        Long userId = userinfo.getUserId();
        if (userId == null) {
            return null;
        }
        String name = "Badges" + id;
        LocalDateTime createDate = LocalDateTime.now() ;
        Badges badges = Badges.builder()
                        .id(id)
                        .userId(userId)
                        .name(name)
                        .createDate(createDate)
                        .build();
        if (!userBadgesDAO.containUserName(userId) || !userBadgesDAO.containBadges(badges)) {
            userBadgesDAO.createBadges(userId,badges);
        }

        return badges;
    }

    @Override
    public Profile genereateProfile(ScoreReq userinfo) {

        // find userinfo in user entity by userid?
        Long userId = userinfo.getUserId();
        userScoreDAO.updateHightestScore(userinfo);
        Integer highestScore = getHighestScore(userId);
        ArrayList<Badges> badges = getUserBadges(userId);

        return Profile.builder()
                .userId(userId)
                .highestScore(highestScore)
                .badges(badges)
                .build();
    }
    public ArrayList<Badges> getUserBadges(Long userId) {
        if (userBadgesDAO.containUserName(userId)) {
            return userBadgesDAO.getBadgesByUserId(userId);
        }
        return null;
    }

    public Integer getHighestScore(Long userId){
        if (userScoreDAO.containUserName(userId)) {
            return userScoreDAO.getHighestScoreByUserId(userId);
        }
        return null;
    }
}
