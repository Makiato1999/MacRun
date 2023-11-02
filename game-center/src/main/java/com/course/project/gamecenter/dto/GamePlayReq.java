package com.course.project.gamecenter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GamePlayReq {

    private Long userId;
    private Integer attackId;
    private Long longitude;
    private Long latitude;
    private Integer heartRateCnt;
}
