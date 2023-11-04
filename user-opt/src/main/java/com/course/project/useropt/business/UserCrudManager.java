package com.course.project.useropt.business;

import com.course.project.useropt.business.entities.UserEntity;
import com.course.project.useropt.domain.event.producer.UserRegisterProducer;
import com.course.project.useropt.domain.repository.UserRepository;
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
        UserEntity res = userRepository.addNewUser(userEntity.getUserName(), userEntity.getEmail());

        //send mq to queue
        userRegisterProducer.sender(res);

        return res;
    }
}
