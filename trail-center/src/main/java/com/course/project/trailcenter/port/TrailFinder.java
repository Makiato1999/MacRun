package com.course.project.trailcenter.port;

import com.course.project.trailcenter.business.entities.TrailEntity;

import java.util.List;

public interface TrailFinder {
    List<TrailEntity> findTrails();
    TrailEntity findTrailById(Long trailId);
    List<TrailEntity> findTrailByUsername(String username);
}
