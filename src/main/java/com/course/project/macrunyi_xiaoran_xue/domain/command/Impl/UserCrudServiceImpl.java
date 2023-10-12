package com.course.project.macrunyi_xiaoran_xue.domain.command.Impl;

import com.course.project.macrunyi_xiaoran_xue.domain.command.UserCrudService;
import com.course.project.macrunyi_xiaoran_xue.domain.entity.UserEntity;
import com.course.project.macrunyi_xiaoran_xue.domain.event.producer.UserRegisterProducer;
import com.course.project.macrunyi_xiaoran_xue.domain.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserCrudServiceImpl implements UserCrudService {
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
