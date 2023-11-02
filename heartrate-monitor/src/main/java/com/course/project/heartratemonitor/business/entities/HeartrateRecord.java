package com.course.project.heartratemonitor.business.entities;


import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor @RequiredArgsConstructor
@Getter @Setter
@ToString
public class HeartrateRecord {

    private @NonNull Long workoutId;
    private @NonNull LocalDateTime dateTime; // date and time of the heart rate record
    private @NonNull Integer heartrate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeartrateRecord record = (HeartrateRecord) o;
        return Objects.equals(dateTime, record.dateTime) && heartrate.equals(record.heartrate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, heartrate);
    }

}