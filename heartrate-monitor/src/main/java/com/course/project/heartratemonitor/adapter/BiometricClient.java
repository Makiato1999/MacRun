package com.course.project.heartratemonitor.adapter;


import com.course.project.heartratemonitor.RabbitConfiguration;
import com.course.project.heartratemonitor.business.entities.HeartrateRecord;
import com.course.project.heartratemonitor.ports.BiometricService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;
import java.util.Random;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Slf4j
@Service
public class BiometricClient implements BiometricService {
    private final RabbitTemplate rabbitTemplate;
    private static final String APP_NAME = "BIOMETRIC-SERVICE";
    private static final String ENDPOINT = "v1/workouts";
//    private final EurekaClient registry;


//    @Autowired
//    public BiometricClient(RabbitTemplate rabbitTemplate, EurekaClient registry) {
//        this.rabbitTemplate = rabbitTemplate;
//        this.registry = registry;
//    }
//    private String locateExternalService() {
//        Application candidates = registry.getApplication(APP_NAME);
//        if (Objects.isNull(candidates)) { // no email service in the registry
//            throw new IllegalStateException();
//        }
//        Random rand = new Random();
//        InstanceInfo infos = // Randomly picking one email service among candidates
//                candidates.getInstances().get(rand.nextInt(candidates.size()));
//        return "http://"+infos.getIPAddr()+":"+infos.getPort();
//    }

    @Autowired
    public BiometricClient(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

//    private WebClient buildClient() {
//        String link = locateExternalService(); //"http://localhost:8082";
//        log.info("** Using instance: " + link);
//        return WebClient.builder()
//                .baseUrl(link)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//    }

    @Override
    public void sendHeartrate(Long workoutId, Long Longitude, Long Latitude, Integer heartrate) {
        HeartrateRecord heartrateRecord = new HeartrateRecord(workoutId, Longitude, Latitude, heartrate);
        rabbitTemplate.convertAndSend(RabbitConfiguration.EXCHANGE_NAME,
                RabbitConfiguration.ROUTING_KEY, heartrateRecord);
    }

    @Override
    public HeartrateRecord createHeartrateRecord(Long userID) {
        Random random = new Random();
        Long randomLat = -90 + (90 - (-90)) * random.nextLong();
        Long randomLong = -180 + (180 - (-180)) * random.nextLong();

        return new HeartrateRecord(userID, randomLat, randomLong, 80);
    }


}

