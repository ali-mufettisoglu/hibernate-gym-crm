package org.example.facade;

import lombok.RequiredArgsConstructor;
import org.example.persistence.GymMap;
import org.example.service.TraineeService;
import org.example.service.TrainerService;
import org.example.service.TrainingService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GymCrmFacadeImpl implements GymCrmFacade{
    private final TraineeService traineeService;
    private final TrainerService trainerService;
    private final TrainingService trainingService;
    private final GymMap gymMap;

    @Override
    public void createTraining() {
    }
}
