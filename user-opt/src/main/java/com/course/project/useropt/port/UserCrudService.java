package com.course.project.useropt.port;

import com.course.project.useropt.business.entities.UserEntity;

public interface UserCrudService {

    UserEntity register(UserEntity userEntity);

    UserEntity getUser(Long userID);
}
