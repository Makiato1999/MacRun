package com.course.project.gamecenter.business.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GamePlayEntity {

    private Long userId;
    private Integer attackId;
    private String attackName;
    private Integer score;
    private Date date;
}
