package com.course.project.useropt.business;

import com.course.project.useropt.business.entities.UserEntity;
import com.course.project.useropt.domain.producer.UserRegisterProducer;
import com.course.project.useropt.repository.UserRepository;
import com.course.project.useropt.port.UserCrudService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserCrudManager implements UserCrudService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserRegisterProducer userRegisterProducer;

    @Override
    public UserEntity register(UserEntity userEntity) {
        UserEntity res = userRepository.addNewUser(userEntity.getEmail(), userEntity.getUserName());
        if (res == null) {
            return null;
        }

        log.info("【Scenario101 - UserRegister】-【UserCenter】user register msg sent to mq (Destination: 【TrailCenter】), userId={},userName={}", res.getUserId(), res.getUserName());
        // send mq to queue
        userRegisterProducer.sender(res);
        return res;
    }
}
