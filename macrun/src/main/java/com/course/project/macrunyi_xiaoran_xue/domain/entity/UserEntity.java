package com.course.project.macrunyi_xiaoran_xue.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 8427779040804874577L;

    private Long userId;
    private String userName;
    private String email;
    private String longitude;
    private String latitude;
}
