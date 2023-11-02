package com.course.project.gamecenter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameAttackDataReq {

    private Long userId;
    private Integer heartRate;
    private Date recordDate;
}
