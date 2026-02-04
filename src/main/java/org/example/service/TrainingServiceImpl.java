package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TrainingDaoImpl;
import org.example.domain.Trainee;
import org.example.domain.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    TrainingDaoImpl trainingDaoImpl;

    @Override
    public Training create(Training training) {
        log.info("create has been called");
        return trainingDaoImpl.create(training);
    }

    @Override
    public Training select(Long id) {
        log.info("select ahs been called");
        return trainingDaoImpl.select(id);
    }
}
