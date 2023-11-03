package com.course.project.challengecenter.business.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Badges {

    private Long id;
    private Long userId;
    private String name;
    private LocalDateTime createDate;


}
