package org.example.domain;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class Trainer extends User {
    private String userName;
    private String specialization;
    private Long userId;
    private Training training;
    private TrainingType trainingType;

    public Trainer(String firstName, String lastName, boolean isActive,String specialization, Long userId) {
        super(firstName, lastName, isActive);
        this.userName = firstName + "." + lastName;
        this.specialization = specialization;
        this.userId = userId;
    }
}
