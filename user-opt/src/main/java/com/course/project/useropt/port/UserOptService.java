package com.course.project.useropt.port;

import com.course.project.useropt.business.entities.UserOptEntity;

public interface UserOptService {
    UserOptEntity operate(Integer optID);
}