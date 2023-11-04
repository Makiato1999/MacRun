package com.course.project.challengecenter.business.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    private Long userId;
    private Integer highestScore;
    private ArrayList<Badges> badges;


}
