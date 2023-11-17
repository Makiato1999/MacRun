package com.course.project.useropt.entities;

import com.course.project.useropt.business.entities.UserEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class TestUserEntity {
    private UserEntity userEntity;
    private Random random = new Random();
    private Long userId;
    private String name;
    private String email;
    private String longitude;
    private String latitude;
    @Before
    public void init() {
        userId = random.nextLong();
        name = "Shawn";
        email = "Shawn123@gmail.com";
        longitude = "45.6789";
        latitude = "12.3456";
        userEntity = new UserEntity(userId, name, email, longitude, latitude);
    }

    @Test
    public void testGetUserID_returnsCorrectUserID() {
        assertEquals(userEntity.getUserId(), userId);
    }
    @Test
    public void testGetUserName_returnsCorrectUserName() {
        assertEquals(userEntity.getUserName(), name);
    }
    @Test
    public void testGetUserEmail_returnsCorrectUserEmail() {
        assertEquals(userEntity.getEmail(), email);
    }
    @Test
    public void testGetUserLongitude_returnsCorrectUserLongitude() {
        assertEquals(userEntity.getLongitude(), longitude);
    }
    @Test
    public void testGetUserLatitude_returnsCorrectUserLatitude() {
        assertEquals(userEntity.getLatitude(), latitude);
    }
    @Test
    public void testSetUserID_returnsCorrectUserID() {
        Long temp_userID = random.nextLong();
        userEntity.setUserId(temp_userID);
        assertEquals(userEntity.getUserId(), temp_userID);
    }
    @Test
    public void testSetUserName_returnsCorrectUserName() {
        String temp_userName = "Dickson";
        userEntity.setUserName(temp_userName);
        assertEquals(userEntity.getUserName(), temp_userName);
    }
    @Test
    public void testSetUserEmail_returnsCorrectUserEmail() {
        String temp_userEmail = "Dickson999@gmail.com";
        userEntity.setEmail(temp_userEmail);
        assertEquals(userEntity.getEmail(), temp_userEmail);
    }
    @Test
    public void testSetUserLongitude_returnsCorrectUserLongitude() {
        String temp_userLongitude = "38.9876";
        userEntity.setLongitude(temp_userLongitude);
        assertEquals(userEntity.getLongitude(), temp_userLongitude);
    }
    @Test
    public void testSetUserLatitude_returnsCorrectUserLatitude() {
        String temp_userLatitude = "-76.5432";
        userEntity.setLatitude(temp_userLatitude);
        assertEquals(userEntity.getLatitude(), temp_userLatitude);
    }
}
