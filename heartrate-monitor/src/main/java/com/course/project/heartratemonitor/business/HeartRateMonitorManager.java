package com.course.project.heartratemonitor.business;
import com.course.project.heartratemonitor.business.entities.HeartrateRecord;
import com.course.project.heartratemonitor.ports.BiometricService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class HeartRateMonitorManager {
    BiometricService biometricService;
    HeartrateRecord heartrateRecord;
    Integer lastHeartRate = 72;
    // minimum heartrate
    private static final Integer MIN_HR = 60;
    // maximum heartrate
    private static final Integer MAX_HR = 200;
    // maximum the heartrate can go up or down by each second
    private static final Integer INTERVAL = 5;

    // this module simulates a heartrate monitor by sending a bunch of heartrates
    public HeartRateMonitorManager(BiometricService biometricService) {
        this.biometricService = biometricService;
        this.heartrateRecord = biometricService.createHeartrateRecord(new Random().nextLong());
    }

    @Scheduled(fixedRate=1000) // https://stackoverflow.com/a/36542208
    public void sendData() {
        Integer heartRate = generateNextHeartrate();
        Random random = new Random();
        Long latitude = -90 + (90 - (-90)) * random.nextLong();
        Long longitude = -180 + (180 - (-180)) * random.nextLong();
        log.info("Sending heartrate: " + heartRate + "bpm");
        biometricService.sendHeartrate(new Random().nextLong(), latitude, longitude, heartRate);
    }

    // Generates the next random heartrate in a sequence, from 60 to 200.
    // The heartrate has a higher probability of going up when closer to 60, and vice versa
    private Integer generateNextHeartrate() {
        Random random = new Random();
        double increaseProb = (double) (MAX_HR - lastHeartRate) / (double) (MAX_HR - MIN_HR);
        Integer increase = (int) Math.round((double) INTERVAL * increaseProb);
        Integer decrease = INTERVAL - increase;
        Integer nextHeartrate = lastHeartRate + (random.nextInt(-decrease, increase));
        log.info("IP: " + increaseProb + ", I: " + increase + ", D: " + decrease + ", HR: " + nextHeartrate);

        this.lastHeartRate = nextHeartrate;

        return nextHeartrate > 200 ? 200
                : nextHeartrate < 60 ? 60
                : nextHeartrate;
    }
}