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
public class GameAttackEntity {

    private Long userId;
    private Integer trailId;
    private Integer attackId;
    private String attackName;
    private Date attackTime;
}
