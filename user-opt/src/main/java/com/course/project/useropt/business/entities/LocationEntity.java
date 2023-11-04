package com.course.project.useropt.business.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LocationEntity {
    private String longitude;
    private String latitude;
}
