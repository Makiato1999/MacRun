package com.course.project.trailcenter.business.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;

@Data
@Builder
@AllArgsConstructor
public class UserEntity {
    @Serial
    private static final long serialVersionUID = 8427779040804874577L;

    private Long userId;
    private String userName;
    private String email;
    private String longitude;
    private String latitude;
}
