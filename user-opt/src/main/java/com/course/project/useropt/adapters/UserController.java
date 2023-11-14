package com.course.project.useropt.adapters;

import com.course.project.useropt.business.UserCrudManager;
import com.course.project.useropt.business.UserOptManager;
import com.course.project.useropt.business.entities.UserOptEntity;
import com.course.project.useropt.dto.UserCrudRequest;
import com.course.project.useropt.business.entities.UserEntity;

import com.course.project.useropt.adapters.resp.Response;
import com.course.project.useropt.dto.UserOptRequest;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = "application/json")
@Slf4j
public class UserController {
    private static final String ENDPOINT = "/user";
    @Resource
    private UserCrudManager userCrudManager;
    @Resource
    private UserOptManager userOptManager;

    @GetMapping(ENDPOINT + "/default")
    public UserEntity defaultUser() {
        return UserEntity.builder().email("Jimmy@mcmaster.ca").userName("Jimmy").build();
    }

    @PostMapping(ENDPOINT + "/register")
    public UserEntity createUserCrud(@RequestBody UserCrudRequest req) {

        log.info("【Scenario1 - User_Register】-【User Center】user action - register, userName={}", req.getUserName());

        UserEntity user = UserEntity.builder().email(req.getEmail()).userName(req.getUserName()).build();
        UserEntity userEntity = userCrudManager.register(user);

        return Response.success(userEntity).getData();
    }

    @PostMapping(ENDPOINT + "/opt")
    public UserOptEntity createUserOpt(@RequestBody UserOptRequest req) {
        UserOptEntity userOpt = userOptManager.operate(req.getOptID());
        return Response.success(userOpt).getData();
    }

    /*
    @RequestMapping(value = "register", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<UserEntity> sendMsg(@RequestParam(required = true) String email, @RequestParam(required = true) String userName) {
        UserEntity user = UserEntity.builder().email(email).userName(userName).build();
        UserEntity userEntity = userCrudService.register(user);
        return Response.success(userEntity);
    }
     */
}
