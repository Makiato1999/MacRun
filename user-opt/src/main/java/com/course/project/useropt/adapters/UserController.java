package com.course.project.useropt.adapters;

import com.course.project.useropt.port.UserCrudService;
import com.course.project.useropt.business.entities.UserEntity;
import com.course.project.useropt.adapters.resp.Response;
import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserCrudService userCrudService;


    @RequestMapping(value = "register", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<UserEntity> sendMsg(@RequestParam(required = true) String email, @RequestParam(required = true) String userName) {

        UserEntity user = UserEntity.builder().email(email).userName(userName).build();

        UserEntity userEntity = userCrudService.register(user);
        return Response.success(userEntity);
    }
}
