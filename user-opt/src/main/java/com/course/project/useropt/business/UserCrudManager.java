package com.course.project.useropt.business;

import com.course.project.useropt.business.entities.UserEntity;
import com.course.project.useropt.domain.producer.UserRegisterProducer;
import com.course.project.useropt.repository.UserRepository;
import com.course.project.useropt.port.UserCrudService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserCrudManager implements UserCrudService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserRegisterProducer userRegisterProducer;

    @Override
    public UserEntity register(UserEntity userEntity) {
        UserEntity res = userRepository.addNewUser(userEntity.getEmail(), userEntity.getUserName());

        // send mq to queue
        userRegisterProducer.sender(res);
        return res;
    }
}
