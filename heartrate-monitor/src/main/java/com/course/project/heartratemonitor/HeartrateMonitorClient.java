package com.course.project.heartratemonitor;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;
import java.util.Random;

@Slf4j
@Service
public class HeartrateMonitorClient {
    private final RabbitTemplate rabbitTemplate;
    private static final String ENDPOINT = "/hrm";
    private static final String APP_NAME = "game-center";

    private final EurekaClient registry;

    @Autowired
    public HeartrateMonitorClient(RabbitTemplate rabbitTemplate, EurekaClient registry) {
        this.rabbitTemplate = rabbitTemplate;
        this.registry = registry;
    }

    private String locateExternalService() {
        Application candidates = registry.getApplication(APP_NAME);
        if (Objects.isNull(candidates)) { // no email service in the registry
            throw new IllegalStateException();
        }
        Random rand = new Random();
        InstanceInfo infos = // Randomly picking one email service among candidates
                candidates.getInstances().get(rand.nextInt(candidates.size()));
        return "http://"+infos.getIPAddr()+":"+infos.getPort();
    }
    private WebClient buildClient() {
        String url = locateExternalService();
        log.info("** Using instance: " + url);
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
