package com.course.project.useropt.business;

import com.course.project.useropt.business.entities.UserOptEntity;
import com.course.project.useropt.domain.producer.UserOptProducer;
import com.course.project.useropt.enums.AttackEnum;
import com.course.project.useropt.port.UserOptService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserOptManager implements UserOptService {
    @Resource
    private UserOptProducer userOptProducer;

    @Override
    public UserOptEntity operate(Integer optID) {
        UserOptEntity res = optPolicy(optID);

        log.info("【Scenario102 - User_Operation】-【User Center】user operation msg sent to mq (Destination: 【Game Center】), userOptId={}", res);
        // send mq to queue
        userOptProducer.sender(res);
        return res;
    }

    private UserOptEntity optPolicy(Integer optID) {
        String optName = AttackEnum.getEnumById(optID).getDesc();
        return UserOptEntity.builder().optID(optID).optName(optName).build();
    }
}
