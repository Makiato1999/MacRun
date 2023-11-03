package com.course.project.heartratemonitor.adapter;


import com.course.project.heartratemonitor.RabbitConfiguration;
//import com.course.project.heartratemonitor.business.entities.HeartrateRecord;
import com.course.project.heartratemonitor.business.entities.HeartrateRecord;
//import com.course.project.heartratemonitor.business.entities.Workout;
//import com.course.project.heartratemonitor.dto.CreateWorkoutRequest;
//import com.course.project.heartratemonitor.dto.EndWorkoutRequest;
import com.course.project.heartratemonitor.ports.BiometricService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

@Slf4j
@Service
public class BiometricClient implements BiometricService {
    private final RabbitTemplate rabbitTemplate;
    private static final String APP_NAME = "BIOMETRIC-SERVICE";
    private static final String ENDPOINT = "v1/workouts";

    @Autowired
    public BiometricClient(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    private WebClient buildClient() {
        String link = "http://localhost:8082";
        log.info("** Using instance: " + link);
        return WebClient.builder()
                .baseUrl(link)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

//    @Override
    public void sendHeartrate(Long workoutId, Long Longitude, Long Latitude, Integer heartrate) {
        HeartrateRecord heartrateRecord = new HeartrateRecord(workoutId, Longitude, Latitude, heartrate);
//        Workout workout = new Workout(workoutId, Longitude, Latitude, heartrate);
        rabbitTemplate.convertAndSend(RabbitConfiguration.EXCHANGE_NAME,
                RabbitConfiguration.ROUTING_KEY, heartrateRecord);
    }

    @Override
    public HeartrateRecord createHeartrateRecord(Long userID) {
        //TODO: random long and lati
        return new HeartrateRecord(userID, (long) 231.332, (long) 111.22, 0);
    }

    //    @Override
//    public Workout createWorkout(int id) {
////        private Long userId;
////        private Long longitude;
////        private Long latitude;
////        private Integer heartRate;
//        CreateWorkoutRequest createWorkoutRequest = new CreateWorkoutRequest();
//        Workout workoutResponse;
//        try {
//            WebClient webClient = buildClient();
//            workoutResponse =
//                    webClient.post()
//                            .uri(ENDPOINT)
//                            .body(BodyInserters.fromValue(createWorkoutRequest))
//                            .retrieve().bodyToMono(Workout.class).block();
//            return workoutResponse;
//        } catch (IllegalStateException ex) {
//            log.error("No biometic service available!");
//            return null;
//        } catch (WebClientException ex) {
//            log.error("Communication Error while sending workout request");
//            log.error(ex.toString());
//            return null;
//        }
//    }

//    @Override
//    public void endWorkout(Long workoutId, LocalDateTime endTime) {
//        EndWorkoutRequest endWorkoutRequest = new EndWorkoutRequest(workoutId, endTime);
//        try {
//            WebClient webClient = buildClient();
//            webClient.patch()
//                    .uri(ENDPOINT+"/"+endWorkoutRequest.getId().toString())
//                    .body(BodyInserters.fromValue(endWorkoutRequest))
//                    .retrieve().bodyToMono(String.class).block();
//        } catch (IllegalStateException ex) {
//            log.error("No biometic service available!");
//        } catch (WebClientException ex) {
//            log.error("Communication Error while sending workout request");
//            log.error(ex.toString());
//        }
//    }

}

