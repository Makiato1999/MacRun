package com.course.project.heartratemonitor.business.entities;


import jakarta.persistence.Id;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor //@RequiredArgsConstructor
@Getter @Setter
@ToString
public class HeartrateRecord implements Serializable {

//    @Serial
//    private static final long serialVersionUID = 3831404271622369215L;

    private @Id Long userId;
    private Long longitude;
    private Long latitude;
    private Integer heartRate;

    public HeartrateRecord(Long userId, Long longitude, Long latitude, Integer heartrate) {
        this.heartRate=heartrate;
        this.longitude=longitude;
        this.latitude=latitude;
        this.userId=userId;

    }

    public Long getId() {
        return this.userId;
    }
}