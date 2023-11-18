package com.course.project.useropt.service;

import com.course.project.useropt.business.UserCrudManager;
import com.course.project.useropt.business.entities.UserEntity;
import com.course.project.useropt.port.UserCrudService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestUserCrudService {
    @TestConfiguration
    static class TestUserCrudServiceContextConfiguration {
        @Bean
        public UserCrudService userCrudManager() {
            return new UserCrudManager();
        }
    }
    @Mock
    private UserCrudService userCrudService;

    private UserEntity userEntity;
    private Long userId;
    private String name;
    private String email;
    private String longitude;
    private String latitude;
    private Random random = new Random();

    @Before
    public void init() {
        userId = random.nextLong();
        name = "Shawn";
        email = "Shawn123@gmail.com";
        longitude = "45.6789";
        latitude = "12.3456";
        userEntity = new UserEntity(userId, name, email, longitude, latitude);

        Mockito.when(userCrudService.register(userEntity)).
                thenReturn(userEntity);
    }

    @Test
    public void testUserCrud_returnsCorrectUserCrud() {
        UserEntity user = userCrudService.register(userEntity);

        assertEquals(user.getUserId(), userId);
        assertEquals(user.getUserName(), name);
        assertEquals(user.getEmail(), email);
        assertEquals(user.getLongitude(), longitude);
        assertEquals(user.getLatitude(), latitude);
    }
}
