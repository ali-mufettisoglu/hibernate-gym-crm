package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TrainingType {
    String name;
    Trainer trainer;
    Training training;

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
