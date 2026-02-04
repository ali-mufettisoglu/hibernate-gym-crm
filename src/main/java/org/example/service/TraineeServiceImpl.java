package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TraineeDaoImpl;
import org.example.domain.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TraineeServiceImpl implements TraineeService {

    @Autowired
    private TraineeDaoImpl traineeDaoImpl;

    @Override
    public Trainee create(Trainee trainee) {
        log.info("create has been called");
        return traineeDaoImpl.create(trainee);
    }

    @Override
    public Trainee update(Trainee trainee) {
        log.info("update has been called");
        return traineeDaoImpl.update(trainee);
    }

    @Override
    public Trainee delete(Long id) {
        log.info("delete has been called");
        return traineeDaoImpl.delete(id);
    }

    @Override
    public Trainee select(Long id) {
        log.info("select has been called");
        return traineeDaoImpl.select(id);
    }
}
