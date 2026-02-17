package org.example.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TrainingDao;
import org.example.domain.Training;
import org.example.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingDao trainingDao;

    @Override
    public Training create(Training training) {
        log.info("create has been called");
        return trainingDao.create(training);
    }

    @Override
    public Training select(Long id) {
        log.info("select ahs been called");
        return trainingDao.select(id);
    }
}
