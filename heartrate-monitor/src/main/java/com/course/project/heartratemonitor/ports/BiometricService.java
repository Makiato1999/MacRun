package com.course.project.heartratemonitor.ports;

import com.course.project.heartratemonitor.business.entities.Workout;

import java.time.LocalDateTime;

public interface BiometricService {
    void sendHeartrate(Long workoutId, LocalDateTime dateTime, Integer heartrate);
    Workout createWorkout(String username);
    void endWorkout(Long workoutId, LocalDateTime endTime);
}
