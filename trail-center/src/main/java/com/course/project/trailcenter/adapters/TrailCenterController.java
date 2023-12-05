package com.course.project.trailcenter.adapters;

import com.course.project.trailcenter.business.TrailCenterManager;
import com.course.project.trailcenter.business.entities.TrailEntity;
import com.course.project.trailcenter.dto.CreateTrailRequest;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = "application/json")
public class TrailCenterController {
    private static final String ENDPOINT = "/trail";

    @Resource
    private TrailCenterManager manager;

    @Autowired
    public TrailCenterController(TrailCenterManager manager) {
        this.manager = manager;
    }

    @GetMapping(ENDPOINT + "/details")
    public TrailEntity findTrail(@RequestParam("userID") Long userId) {
        return manager.findTrailAllocation(userId);
    }

    // provide customized geographic information to users
    @PostMapping(ENDPOINT + "/localization")
    public TrailEntity setTrail(@RequestBody CreateTrailRequest req) {
        return manager.setTrailAllocation(req.getUserId(), req.getLongitude(), req.getLatitude());
    }

}
