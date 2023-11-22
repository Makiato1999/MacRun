package com.course.project.useropt.integration;

import com.course.project.useropt.UserOptApplication;
import com.course.project.useropt.business.entities.UserEntity;
import com.course.project.useropt.business.entities.UserOptEntity;
import com.course.project.useropt.port.UserCrudService;
import com.course.project.useropt.port.UserOptService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@SpringBootTest(
//        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
//        classes = UserOptApplication.class)
//@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:integration-tests-config.properties")

//public class UserOptRestControllerIntegrationTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private UserCrudService userCrudService;
//
//    @Autowired
//    private UserOptService userOptService;
//
//    private String req_email;
//    private String req_userName;
//    private Integer req_optID;
//    private UserEntity userEntity;
//    private UserOptEntity userOptEntity;
//
//    @Test
//    public void testUserCrud_whenPostUserEntity_thenStatus200()
//            throws Exception {
//
//        req_email = "Dickson123@gmail.com";
//        req_userName = "Dickson";
//        userEntity = UserEntity.builder().email(req_email).userName(req_userName).build();
//        String jsonRequestBody = "{"
//                + "\"email\": \"" + req_email + "\","
//                + "\"userName\": \"" + req_userName + "\""
//                + "}";
//        userEntity.setEmail(req_email);
//        userEntity.setUserName(req_userName);
//        userCrudService.register(userEntity);
//
//        MvcResult result = mvc.perform(post("/user/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonRequestBody))
//                .andExpect(status().isOk())
//                .andExpect(content()
//                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andReturn();
//        String responseContent = result.getResponse().getContentAsString();
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(responseContent);
//        String res_email = jsonNode.get("email").asText();
//        String res_userName = jsonNode.get("userName").asText();
//
//        assertEquals(req_email, res_email);
//        assertEquals(req_userName, res_userName);
//    }
//
//    @Test
//    public void testUserOpt_whenPostUserOptEntity_thenStatus200()
//            throws Exception {
//
//        req_optID = 3;
//        String jsonRequestBody = "{"
//                + "\"optID\": \"" + req_optID + "\""
//                + "}";
//        userOptService.operate(req_optID);
//
//        MvcResult result = mvc.perform(post("/user/opt")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonRequestBody))
//                .andExpect(status().isOk())
//                .andExpect(content()
//                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andReturn();
//        String responseContent = result.getResponse().getContentAsString();
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(responseContent);
//        Integer res_optID = jsonNode.get("optID").asInt();
//        assertEquals(res_optID, res_optID);
//    }
//}

// how to run: mvn verify -Psurefire
