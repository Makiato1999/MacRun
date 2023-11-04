package com.course.project.challengecenter.repo;

import com.course.project.challengecenter.business.entity.Badges;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserBadgesDAO {

    private static Map<Long, ArrayList<Badges>> userBadgesMap = new HashMap<>();


    public Boolean containUserName(Long userId) {
        return userBadgesMap.containsKey(userId);
    }

    public Boolean containBadges(Long userId, Badges badges) {
        return userBadgesMap.get(userId).contains(badges);
    }

    public void createBadges(Long userId, Badges badges) {
        if (!containUserName(userId)) {
            ArrayList<Badges> badgesList = new ArrayList<Badges>();
            badgesList.add(badges);
            userBadgesMap.put(userId, badgesList);
        } else {
            ArrayList<Badges> badgesList = userBadgesMap.get(userId);
            List<String> badgeName = badgesList.stream()
                    .map(Badges::getName)
                    .collect(Collectors.toList());
            if (!badgeName.contains(badges.getName())) {
                badgesList.add(badges);
                userBadgesMap.put(userId, badgesList);
            }

        }
    }

    public ArrayList<Badges> getBadgesByUserId(Long userId) {
        return userBadgesMap.get(userId);
    }

    public boolean alreadyExist(Long userId, Badges badges) {
        if (containUserName(userId) || containBadges(userId, badges)) {
            return false;
        }
        return true;
    }
}
