package com.course.project.useropt.business;

import com.course.project.useropt.business.entities.UserEntity;
import com.course.project.useropt.domain.producer.UserRegisterProducer;
import com.course.project.useropt.repository.UserRepository;
import com.course.project.useropt.port.UserCrudService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class UserCrudManager implements UserCrudService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserRegisterProducer userRegisterProducer;

    // Users
    private UserEntity user = null;
    private Map<Long, UserEntity> activeUsers = new ConcurrentHashMap<>();

    @Override
    public UserEntity register(UserEntity userEntity) {
        UserEntity res = userRepository.addNewUser(userEntity.getEmail(), userEntity.getUserName());
        activeUsers.put(res.getUserId(), res);
        if (res == null) {
            return null;
        }
        log.info("【Scenario101 - UserCenter】-【UserCenter】user launching msg sent to mq (Destination: 【TrailCenter】), userId={},userName={}", res.getUserId(), res.getUserName());
        // send mq to queue
        userRegisterProducer.sender(res);
        return res;
    }

    @Override
    public UserEntity getUser(Long userID) {
        UserEntity res = new UserEntity(userID, null, null, null,null);
        UserEntity value = activeUsers.get(userID);
        if (value != null) {
            res.setUserId(value.getUserId());
            res.setUserName(value.getUserName());
            res.setEmail(value.getEmail());
            res.setLongitude(value.getLongitude());
            res.setLatitude(value.getLatitude());
        } else {
            throw new NoSuchElementException("No user found for userID: " + userID);
        }
        return res;
    }
}
