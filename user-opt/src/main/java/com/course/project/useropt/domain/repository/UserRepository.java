package com.course.project.useropt.domain.repository;

import com.course.project.useropt.business.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserRepository {

    public UserEntity addNewUser(String userEmail, String userName) {
        //todo insert to database
        return new UserEntity(new Random().nextLong(), "userName", "test@mcmaster.ca", "123.45", "678.90");
    }
}
