package com.course.project.trailcenter.business.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
public class TrailEntity {
    private Long userId;

    private Integer trailId;
    private String trailName;
    private ArrayList<Integer> trailMap;
}
