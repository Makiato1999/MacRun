package com.course.project.challengecenter.business;

import com.course.project.challengecenter.business.entity.Badges;
import com.course.project.challengecenter.dto.ScoreReq;
import com.course.project.challengecenter.port.BadgesService;
import com.course.project.challengecenter.repo.UserBadgesDAO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;


@Service
public class BadgesManager implements BadgesService  {

    @Resource
    private UserBadgesDAO userBadgesDAO = new UserBadgesDAO();

    @Override
    public Badges generateBadges(ScoreReq userinfo) {
        Long id = new Random().nextLong();
        Long userId = userinfo.getUserId();
        String name;
        if (userId == null) {
            return null;
        }
        if (userinfo.getScore() >= 90) {
            name = "Advanced Badge";
        } else if (userinfo.getScore() >= 80 && userinfo.getScore() < 90) {
            name = "Intermedia Badge";
        } else if (userinfo.getScore() >= 70 && userinfo.getScore() < 80) {
            name = "Starter Badge";
        } else {
            return null;
        }

        LocalDateTime createDate = LocalDateTime.now();
        Badges badges = Badges.builder()
                .id(id)
                .userId(userId)
                .name(name)
                .createDate(createDate)
                .build();
        userBadgesDAO.createBadges(userId, badges);
        return badges;
    }
}
