package com.course.project.heartratemonitor.adapter;

import com.course.project.heartratemonitor.business.HeartRateMonitorManager;
import com.course.project.heartratemonitor.business.entities.Workout;
import com.course.project.heartratemonitor.dto.createWorkoutRequest;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(produces = "application/json")
@Slf4j
public class HeartrateMonitorController {
    private static final String ENDPOINT = "/hrm";
    @Resource
    private HeartRateMonitorManager heartRateMonitorManager;

    @PostMapping(ENDPOINT + "/workout/starter")
    public Workout createWorkout(@RequestBody createWorkoutRequest req) {
        Long workoutID = heartRateMonitorManager.generateWorkoutID();
        return heartRateMonitorManager.startWorkout(workoutID, req.getUserID());
    }
    @GetMapping(ENDPOINT + "/workout/details")
    public Workout findWorkout(@RequestParam("userID") Long userId) {
        return heartRateMonitorManager.getWorkout(userId);
    }
    /*
    @PostMapping(ENDPOINT + "/workout/end")
    public void endWorkout(@RequestBody endWorkoutRequest req) {
        heartRateMonitorManager.endWorkout(req.getUserID());
    }
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
}
