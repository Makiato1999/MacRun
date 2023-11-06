package com.course.project.challengecenter.business;

import com.course.project.challengecenter.business.entity.Badges;
import com.course.project.challengecenter.business.entity.Profile;
import com.course.project.challengecenter.dto.ScoreReq;
import com.course.project.challengecenter.port.ProfileService;
import com.course.project.challengecenter.repo.UserBadgesDAO;
import com.course.project.challengecenter.repo.UserScoreDAO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileManager implements ProfileService {

    @Resource
    private UserBadgesDAO userBadgesDAO = new UserBadgesDAO();

    @Resource
    private UserScoreDAO userScoreDAO = new UserScoreDAO();

    @Override
    public Profile generateProfile(ScoreReq userinfo) {

        Long userId = userinfo.getUserId();
        userScoreDAO.updateHighestScore(userinfo);
        Integer highestScore = getHighestScore(userId);
        List<Badges> badges = getUserBadges(userId);

        return Profile.builder().userId(userId).highestScore(highestScore).badges(badges).build();
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
