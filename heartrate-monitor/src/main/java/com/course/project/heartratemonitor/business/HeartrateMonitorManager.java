package com.course.project.heartratemonitor.business;
import com.course.project.heartratemonitor.business.entities.HeartrateRecord;
//import com.course.project.heartratemonitor.business.entities.Workout;
import com.course.project.heartratemonitor.ports.BiometricService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@Slf4j
public class HeartrateMonitorManager {
    BiometricService biometricService;

    HeartrateRecord heartrateRecord;
//    Workout workout;
    Integer lastHeartrate = 72;
    private static final Integer MIN_HR = 60;  // minimum heartrate
    private static final Integer MAX_HR = 200; // maximum heartrate
    private static final Integer INTERVAL = 5; // maximum the heartrate can go up or down by each second

    // this module simulates a heartrate monitor by registering a new workout and then sending a bunch of heartrates, one per second, until it's turned off
    public HeartrateMonitorManager(BiometricService biometricService) {
        this.biometricService = biometricService;

        this.heartrateRecord = biometricService.createHeartrateRecord(new Random().nextLong());
        // register a new workout
//        this.workout = biometricService.createWorkout(0);
    }

    @Scheduled(fixedRate=1000) // https://stackoverflow.com/a/36542208
    public void sendData() {
        //while(shouldKeepSendingData) {
        Integer heartrate = generateNextHeartrate();

        log.info("Sending heartrate: " + heartrate + "bpm");
        biometricService.sendHeartrate(heartrateRecord.getId(), heartrateRecord.getLongitude(), heartrateRecord.getLatitude(), heartrate);

    }

    // Generates the next random heartrate in a sequence, from 60 to 200.
    // The heartrate has a higher probability of going up when closer to 60, and vice versa
    private Integer generateNextHeartrate() {
        Random random = new Random();
        double increaseProb = (double) (MAX_HR - lastHeartrate) / (double) (MAX_HR - MIN_HR);
        Integer increase = (int) Math.round((double) INTERVAL * increaseProb);
        Integer decrease = INTERVAL - increase;
        Integer nextHeartrate = lastHeartrate + (random.nextInt(-decrease, increase));
        log.info("IP: " + increaseProb + ", I: " + increase + ", D: " + decrease + ", HR: " + nextHeartrate);

        this.lastHeartrate = nextHeartrate;

        return nextHeartrate > 200 ? 200
                : nextHeartrate < 60 ? 60
                : nextHeartrate;
    }
}