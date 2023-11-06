package com.course.project.useropt.business;

import com.course.project.useropt.business.entities.UserOptEntity;
import com.course.project.useropt.domain.producer.UserOptProducer;
import com.course.project.useropt.enums.AttackEnum;
import com.course.project.useropt.port.UserOptService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserOptManager implements UserOptService {
    @Resource
    private UserOptProducer userOptProducer;

    @Override
    public UserOptEntity operate(Integer optID) {
        UserOptEntity res = optPolicy(optID);

        // send mq to queue
        userOptProducer.sender(res);
        return res;
    }

    private UserOptEntity optPolicy(Integer optID) {
        String optName = AttackEnum.getEnumById(optID).getDesc();
        return UserOptEntity.builder().optID(optID).optName(optName).build();
    }
}
