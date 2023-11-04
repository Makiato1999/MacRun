package com.course.project.heartratemonitor.ports;

//import com.course.project.heartratemonitor.business.entities.Workout;

import com.course.project.heartratemonitor.business.entities.HeartrateRecord;

import java.time.LocalDateTime;

public interface BiometricService {
    void sendHeartrate(Long userId, Long Longitude, Long Latitude, Integer heartrate);

    HeartrateRecord createHeartrateRecord(Long userID);
//    Workout createWorkout(int workoutID);
}
