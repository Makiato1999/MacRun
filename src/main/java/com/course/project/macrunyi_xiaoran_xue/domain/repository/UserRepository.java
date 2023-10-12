package com.course.project.macrunyi_xiaoran_xue.domain.repository;

import com.course.project.macrunyi_xiaoran_xue.domain.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserRepository {

    public UserEntity addNewUser(String userEmail, String userName) {
        //todo insert to database
        return new UserEntity(new Random().nextLong(), "userName", "test@mcmaster.ca");
    }
}
