package com.course.project.heartratemonitor.adapter;

import com.course.project.heartratemonitor.business.HeartRateMonitorManager;
import com.course.project.heartratemonitor.business.entities.Workout;
import com.course.project.heartratemonitor.dto.createWorkoutRequest;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "application/json")
@Slf4j
public class HeartrateMonitorController {
    private static final String ENDPOINT = "/hrm";
    @Resource
    private HeartRateMonitorManager heartRateMonitorManager;

    @PostMapping(ENDPOINT + "/workout/create")
    public Workout createWorkout(@RequestBody createWorkoutRequest req) {
        Long workoutID = heartRateMonitorManager.generateWorkoutID();
        return heartRateMonitorManager.startWorkout(workoutID, req.getUserID());
    }
    /*
    @PostMapping(ENDPOINT + "/workout/end")
    public void endWorkout(@RequestBody endWorkoutRequest req) {
        heartRateMonitorManager.endWorkout(req.getUserID());
    }
     */
}
