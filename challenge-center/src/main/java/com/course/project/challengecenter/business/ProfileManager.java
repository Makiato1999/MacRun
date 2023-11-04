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
import java.util.List;
import java.util.Random;

@Service
public class ProfileManager implements ProfileService {

    @Resource
    private UserBadgesDAO userBadgesDAO;

    @Resource
    private UserScoreDAO userScoreDAO;

//    @Override
//    public Badges genereateBadges(ScoreReq userinfo) {
//        Long id = new Random().nextLong();
//        Long userId = userinfo.getUserId();
//        String name;
//        if (userId == null) {
//            return null;
//        }
//        if (userinfo.getScore() >= 90) {
//            name = "Advanced Badges";
//        } else if (userinfo.getScore() >= 80 && userinfo.getScore() < 90) {
//            name = "Intermedia Badges";
//        } else if (userinfo.getScore() >= 70 && userinfo.getScore() < 80) {
//            name = "Starter Badges";
//        } else {
//            return null;
//        }
//
////        String name = "Badges" + id;
//        LocalDateTime createDate = LocalDateTime.now();
//        Badges badges = Badges.builder()
//                .id(id)
//                .userId(userId)
//                .name(name)
//                .createDate(createDate)
//                .build();
////        if (!userBadgesDAO.alreadyExist(userId, badges)) {
//        userBadgesDAO.createBadges(userId, badges);
////        }
//        return badges;
//    }

    @Override
    public Profile genereateProfile(ScoreReq userinfo) {

        // find userinfo in user entity by userid?
        Long userId = userinfo.getUserId();
        userScoreDAO.updateHighestScore(userinfo);
        Integer highestScore = getHighestScore(userId);
        List<Badges> badges = getUserBadges(userId);

        return Profile.builder()
                .userId(userId)
                .highestScore(highestScore)
                .badges(badges)
                .build();
    }

    public List<Badges> getUserBadges(Long userId) {
        if (userBadgesDAO.containUserName(userId)) {
            return userBadgesDAO.getBadgesByUserId(userId);
        }
        return null;
    }

    public Integer getHighestScore(Long userId) {
        if (userScoreDAO.containUserName(userId)) {
            return userScoreDAO.getHighestScoreByUserId(userId);
        }
        return null;
    }
}
