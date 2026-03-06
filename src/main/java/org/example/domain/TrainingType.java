package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrainingType {
    private String name;
    private Trainer trainer;
    private Training training;

    public TrainingType(String name){
        this.name = name;
    }
    public TrainingType(String name,Trainer trainer){
        this.name = name;
        this.trainer = trainer;
    }
    public TrainingType(String name,Training training){
        this.name = name;
        this.training = training;
    }
}
