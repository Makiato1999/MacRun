package com.course.project.useropt.service;

import com.course.project.useropt.business.UserCrudManager;
import com.course.project.useropt.business.UserOptManager;
import com.course.project.useropt.business.entities.UserEntity;
import com.course.project.useropt.business.entities.UserOptEntity;
import com.course.project.useropt.port.UserCrudService;
import com.course.project.useropt.port.UserOptService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestUserOptService {
    @TestConfiguration
    static class TestUserOptServiceContextConfiguration {
        @Bean
        public UserOptService userOptManager() {
            return new UserOptManager();
        }
    }
    @Mock
    private UserOptService userOptService;

    private UserOptEntity userOptEntity;
    private Integer optID;
    private String optName;

    @Before
    public void init() {
        optID = 3;
        optName = "FIGHTING_BACK";
        userOptEntity = new UserOptEntity(optID, optName);

        Mockito.when(userOptService.operate(optID)).
                thenReturn(userOptEntity);
    }

    @Test
    public void testUserCrud_returnsCorrectUserCrud() {
        UserOptEntity opt = userOptService.operate(optID);

        assertEquals(opt.getOptID(), optID);
        assertEquals(opt.getOptName(), optName);
    }

}
