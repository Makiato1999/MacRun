package com.course.project.trailcenter.adapters;

import com.course.project.trailcenter.adapters.resp.Response;
import com.course.project.trailcenter.business.TrailManager;
import com.course.project.trailcenter.business.entities.TrailEntity;
import com.course.project.trailcenter.dto.CreateTrailRequest;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class TrailController {
    private static final String ENDPOINT = "/trail";

    private final TrailManager manager;
    /*
    @Resource
    private TrailProducer trailSender;
    */

    @Autowired
    public TrailController(TrailManager manager) {
        this.manager = manager;
    }

    @GetMapping(ENDPOINT)
    public String info() {
        return "OK";
    }
    @PostMapping(ENDPOINT + "/allocation")
    public TrailEntity createTrail(@RequestBody CreateTrailRequest req) {
        return manager.create(req.getUserId(), req.getLongitude(), req.getLatitude());
    }

    /*
    @GetMapping(ENDPOINT + "/allocation")
    public Response findTrail(@RequestParam(required = true) String content) {
        trailSender.sender(content);
        return new Response().success("send success");
    }
    */
}
