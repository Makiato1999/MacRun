package com.course.project.trailcenter.adapters;

import com.course.project.trailcenter.business.TrailCenterManager;
import com.course.project.trailcenter.business.entities.TrailEntity;
import com.course.project.trailcenter.dto.CreateTrailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = "application/json")
public class TrailCenterController {
    private static final String ENDPOINT = "/trail";

    private final TrailCenterManager manager;

    @Autowired
    public TrailCenterController(TrailCenterManager manager) {
        this.manager = manager;
    }

    @GetMapping(ENDPOINT)
    public String defaultPage() {
        return "TrailCenter server starts successfully";
    }

    @PostMapping(ENDPOINT + "/allocation")
    public TrailEntity findTrail(@RequestBody CreateTrailRequest req) {
        return manager.allocate(req.getUserId(), req.getLongitude(), req.getLatitude());
    }

    /*
    @GetMapping(ENDPOINT + "/allocation")
    public Response findTrail(@RequestParam(required = true) String content) {
        trailSender.sender(content);
        return new Response().success("send success");
    }
    */
}
