package com.course.project.useropt.entities;

import com.course.project.useropt.business.entities.UserOptEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUserOptEntity {
    private Integer optID;
    private String optName;
    private UserOptEntity userOptEntity;

    @Before
    public void init() {
        optID = 3;
        optName = "FIGHTING_BACK";
        userOptEntity = new UserOptEntity(optID, optName);
    }

    @Test
    public void testGetOptID_returnsCorrectOptID() {
        assertEquals(userOptEntity.getOptID(), optID);
    }

    @Test
    public void testSetOptID_returnsCorrectOptID() {
        Integer temp_OptID = 1;
        userOptEntity.setOptID(temp_OptID);
        assertEquals(userOptEntity.getOptID(), temp_OptID);
    }

    @Test
    public void testGetOptName_returnsCorrectOptName() {
        assertEquals(userOptEntity.getOptName(), optName);
    }

    @Test
    public void testSetOptName_returnsCorrectOptName() {
        String temp_OptName = "NewOption";
        userOptEntity.setOptName(temp_OptName);
        assertEquals(userOptEntity.getOptName(), temp_OptName);
    }
}

// mvn test