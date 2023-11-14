package com.course.project.challengecenter.port;

import com.course.project.challengecenter.business.entity.Badges;

import java.util.List;
public interface BadgeFinder {

    List<Badges> findAll();
    List<Badges> findByUserId(Long userId);
}
