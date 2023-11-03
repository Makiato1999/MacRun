package com.course.project.trailcenter.port;

import com.course.project.trailcenter.business.entities.TrailEntity;

public interface TrailManagement {
    TrailEntity create(Long userId, String longitude, String latitude);
}
