package com.course.project.heartratemonitor;
import com.course.project.heartratemonitor.adapter.BiometricClient;
import com.course.project.heartratemonitor.business.entities.HeartrateRecord;
import com.netflix.discovery.EurekaClient;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestBiometricClient {

    @Mock
    private RabbitTemplate rabbitTemplate = new RabbitTemplate();

    @InjectMocks
    private BiometricClient biometricClient = new BiometricClient(rabbitTemplate);

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateHeartrateRecord() {
        Long userId = 1L;

        HeartrateRecord heartrateRecord = biometricClient.createHeartrateRecord(userId);

        assertNotNull(heartrateRecord);
        assertEquals(userId, heartrateRecord.getUserId());
        assertNotNull(heartrateRecord.getLatitude());
        assertNotNull(heartrateRecord.getLongitude());
        assertNotNull(heartrateRecord.getHeartRate());
    }

}
