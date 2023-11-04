package com.course.project.useropt.repository;

import com.course.project.useropt.business.entities.UserEntity;
import com.course.project.useropt.utils.GenerateLocationUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserRepository {
    @Resource
    private GenerateLocationUtils location;

    public UserEntity addNewUser(String userEmail, String userName) {
        //todo insert to database
        return new UserEntity(new Random().nextLong(), userName, userEmail,
                location.generate().getLongitude(),location.generate().getLatitude());
    }
}
