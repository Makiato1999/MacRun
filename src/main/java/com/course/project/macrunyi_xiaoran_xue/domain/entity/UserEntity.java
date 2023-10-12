package com.course.project.macrunyi_xiaoran_xue.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserEntity {

    private Long userId;
    private String userName;
    private String email;
}
