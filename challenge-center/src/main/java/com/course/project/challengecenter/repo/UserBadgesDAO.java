package com.course.project.challengecenter.repo;

import com.course.project.challengecenter.business.entity.Badges;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserBadgesDAO {

    private static Map<Long, ArrayList<Badges>> userBadgesMap = new HashMap<>();

//    static {
//        userInfoMap.put(2147483647L, "1");
//        userInfoMap.put(456L, "2");
//        userInfoMap.put(789L, "3");
//    }

    public Boolean containUserName(Long userId) {
        return userBadgesMap.containsKey(userId);
    }
    public Boolean containBadges(Badges badges) {
        return userBadgesMap.containsValue(badges);
    }

    public void createBadges(Long userId, Badges badges) {
        if (!containUserName(userId)){
            ArrayList<Badges> badgesList = new ArrayList<Badges>();
            badgesList.add(badges);
            userBadgesMap.put(userId, badgesList);
        }
        else {
            ArrayList<Badges> badgesList = userBadgesMap.get(userId);
            badgesList.add(badges);
            userBadgesMap.put(userId, badgesList);
        }
    }

    public ArrayList<Badges> getBadgesByUserId(Long userId) {
        return userBadgesMap.get(userId);
    }

}
