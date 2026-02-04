package org.example.persistence;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.Trainee;
import org.example.domain.Trainer;
import org.example.domain.Training;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Component
public class GymMap {
    private Map<Long, Trainer> gymMapTrainer = new HashMap<>();
    private Map<Long, Trainee> gymMapTrainee = new HashMap<>();
    private Map<Long, Training> gymMapTraining = new HashMap<>();
}

