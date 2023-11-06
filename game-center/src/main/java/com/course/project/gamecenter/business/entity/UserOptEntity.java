package com.course.project.gamecenter.business.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserOptEntity {
    private Integer optID;
    private String optName;
}
