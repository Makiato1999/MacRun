package com.course.project.challengecenter.business;


import com.course.project.challengecenter.business.entity.Badges;
import com.course.project.challengecenter.port.BadgeFinder;
import com.course.project.challengecenter.port.BadgeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BadgeRegistry implements BadgeFinder {

    @Autowired
    BadgeRepo badgesRepo;

    @Override
    public List<Badges> findAll() {
        return badgesRepo.findAll();
    }

    @Override
    public List<Badges> findByUserId(Long userId) {
        return badgesRepo.findByUserId(userId);
    }
}


