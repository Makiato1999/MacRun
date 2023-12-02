package com.course.project.gamecenter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameAttackReq {

    private Long userId;
    private Long longitude;
    private Long latitude;
    private Integer heartRate;
}
