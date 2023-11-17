package com.course.project.useropt.integration;

import com.course.project.useropt.UserOptApplication;
import com.course.project.useropt.port.UserCrudService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = UserOptApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:integration-tests-config.properties")

public class UserOptRestControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserCrudService userCrudService;
}
