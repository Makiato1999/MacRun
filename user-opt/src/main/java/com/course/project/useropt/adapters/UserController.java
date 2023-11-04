package com.course.project.useropt.adapters;

import com.course.project.useropt.business.UserCrudManager;
import com.course.project.useropt.dto.CreateUserRequest;
import com.course.project.useropt.business.entities.UserEntity;

import com.course.project.useropt.adapters.resp.Response;
import com.course.project.useropt.business.entities.UserEntity;
import com.course.project.useropt.port.UserCrudService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = "application/json")
public class UserController {
    private static final String ENDPOINT = "/user";
    @Resource
    private UserCrudManager userCrudManager;

    @GetMapping(ENDPOINT + "/default")
    public UserEntity defaultUser() {
        return UserEntity.builder().email("Jimmy@mcmaster.ca").userName("Jimmy").build();
    }

    @PostMapping(ENDPOINT + "/register")
    public UserEntity sendMsg(@RequestBody CreateUserRequest req) {
        UserEntity user = UserEntity.builder().email(req.getEmail()).userName(req.getUserName()).build();
        UserEntity userEntity = userCrudManager.register(user);
        return Response.success(userEntity).getData();
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
