package com.course.project.heartratemonitor.dto;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EndWorkoutRequest {
    private Long id;
    private LocalDateTime endTime;
}