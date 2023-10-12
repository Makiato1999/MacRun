package com.course.project.macrunyi_xiaoran_xue.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;


@Builder
@AllArgsConstructor
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 8427779040804874577L;

    private Long userId;
    private String userName;
    private String email;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
