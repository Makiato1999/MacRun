package com.course.project.trailcenter.port;

import com.course.project.trailcenter.business.entities.TrailEntity;

public interface TrailCenterService {
    TrailEntity findTrailAllocation(Long userId);
    TrailEntity setTrailAllocation(Long userId, String longitude, String latitude);
}
