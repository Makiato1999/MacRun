package com.course.project.heartratemonitor.business.entities;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class Workout {
    private Long workoutId;
    private Long userID;
    private LocalDateTime startTime;
}
