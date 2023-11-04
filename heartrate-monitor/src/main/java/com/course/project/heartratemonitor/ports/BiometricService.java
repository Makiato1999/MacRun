package com.course.project.heartratemonitor.ports;
import com.course.project.heartratemonitor.business.entities.HeartrateRecord;


public interface BiometricService {
    void sendHeartrate(Long userId, Long Longitude, Long Latitude, Integer heartrate);

    HeartrateRecord createHeartrateRecord(Long userID);
}
