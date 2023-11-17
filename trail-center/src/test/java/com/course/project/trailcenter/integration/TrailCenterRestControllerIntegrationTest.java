package com.course.project.trailcenter.integration;

import com.course.project.trailcenter.TrailCenterApplication;
import com.course.project.trailcenter.port.TrailCenterService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = TrailCenterApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:integration-tests-config.properties")

public class TrailCenterRestControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private TrailCenterService service;

    private Long req_userId;
    private String req_longitude;
    private String req_latitude;
    private Random random = new Random();

    @Test
    public void testTrailAllocation_whenPostUserEntity_thenStatus200()
            throws Exception {
        req_userId = random.nextLong();
        req_longitude = "45.6789";
        req_latitude = "12.3456";
        String jsonRequestBody = "{"
                + "\"userId\": " + req_userId + ","
                + "\"longitude\": \"" + req_longitude + "\","
                + "\"latitude\": \"" + req_latitude + "\""
                + "}";

        service.allocate(req_userId, req_longitude, req_latitude);

        MvcResult result = mvc.perform(post("/trail/allocation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequestBody))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        String responseContent = result.getResponse().getContentAsString();
        // System.out.println("Response Content: " + responseContent);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseContent);
        Long res_userId = jsonNode.get("userId").asLong();
        assertEquals(res_userId, req_userId);
    }
}

// how to run: mvn verify -Psurefire
