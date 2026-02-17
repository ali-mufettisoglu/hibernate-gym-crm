package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Training {
    private Long traineeId;
    private Long trainerId;
    private String name;
    private String trainingType;
    private String date;
    private String duration;
    private Long id;

    public Training(String name, String trainingType, String date, String duration, Long id) {
        this.name = name;
        this.trainingType = trainingType;
        this.date = date;
        this.duration = duration;
        this.id = id;
    }
}
