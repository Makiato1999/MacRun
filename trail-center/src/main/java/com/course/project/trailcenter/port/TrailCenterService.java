package com.course.project.trailcenter.port;

import com.course.project.trailcenter.business.entities.TrailEntity;

public interface TrailCenterService {
    TrailEntity allocate(Long userId, String longitude, String latitude);
    void sendTrail(TrailEntity trailEntity);
}
