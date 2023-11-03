package com.course.project.trailcenter.business.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TrailEntity {
    private Integer trailId;
    private String trailName;
}
