package com.course.project.trailcenter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTrailRequest {
    private Long userId;
    private String longitude;
    private String latitude;
}