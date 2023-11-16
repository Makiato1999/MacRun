package com.course.project.useropt.entities;

import com.course.project.useropt.business.entities.LocationEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLocationEntity {
    private String longitude;
    private String latitude;
    private LocationEntity locationEntity;
    @Before
    public void init() {
        longitude = "45.6789";
        latitude = "12.3456";
        locationEntity = new LocationEntity(longitude, latitude);
    }
    @Test
    public void testGetLongitude_returnsCorrectLongitude() {
        assertEquals(locationEntity.getLongitude(), longitude);
    }

    @Test
    public void testSetLongitude_returnsCorrectLongitude() {
        String temp_Longitude = "23.1972";
        locationEntity.setLongitude(temp_Longitude);
        assertEquals(locationEntity.getLongitude(), temp_Longitude);
    }

    @Test
    public void testGetLatitude_returnsCorrectLatitude() {
        assertEquals(locationEntity.getLatitude(), latitude);
    }

    @Test
    public void testSetLatitude_returnsCorrectLatitude() {
        String temp_Latitude = "11.8273";
        locationEntity.setLatitude(temp_Latitude);
        assertEquals(locationEntity.getLatitude(), temp_Latitude);
    }
}

// mvn test