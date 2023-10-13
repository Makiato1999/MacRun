package com.course.project.macrunyi_xiaoran_xue.domain.command;

import com.course.project.macrunyi_xiaoran_xue.domain.entity.UserEntity;

public interface UserCrudService {

    UserEntity register(UserEntity userEntity);
}
