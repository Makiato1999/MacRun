package com.course.project.macrunyi_xiaoran_xue.domain.command;


import com.course.project.macrunyi_xiaoran_xue.domain.entity.TrailEntity;

public interface TrailService {

    TrailEntity allocateTrail(Long userId, String longitude, String latitude);
}
