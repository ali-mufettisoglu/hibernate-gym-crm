package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TrainerDaoImpl;
import org.example.domain.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    TrainerDaoImpl trainerDaoImpl;

    @Override
    public Trainer create(Trainer trainer) {
        log.info("create has been called");
        return trainerDaoImpl.create(trainer);
    }

    @Override
    public Trainer update(Trainer trainer) {
        log.info("delete has been called");
        return trainerDaoImpl.update(trainer);
    }

    @Override
    public Trainer select(Long id) {
        log.info("select has been called");
        return trainerDaoImpl.select(id);
    }
}
