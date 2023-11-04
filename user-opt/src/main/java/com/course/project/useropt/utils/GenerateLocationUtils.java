package com.course.project.useropt.utils;

import com.course.project.useropt.business.entities.LocationEntity;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GenerateLocationUtils {
    private final Random random = new Random();

    public LocationEntity generate() {
        // Latitude range: -90 to +90
        double latitude = -90.0 + 180.0 * random.nextDouble();
        // Longitude range: -180 to +180
        double longitude = -180.0 + 360.0 * random.nextDouble();

        return new LocationEntity(Double.toString(latitude), Double.toString(longitude));
    }
}
