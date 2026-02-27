package org.example.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TrainerDao;
import org.example.domain.Trainer;
import org.example.service.TrainerService;
import org.example.service.Impl.filters.Duplicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerDao trainerDao;

    @Autowired
    private Duplicates<Trainer> duplicates;

    @Override
    public Trainer create(Trainer trainer) {
        log.info("create has been called");
        return trainerDao.create(duplicates.searchDuplicates(trainer));
    }

    @Override
    public Trainer update(Trainer trainer) {
        log.info("delete has been called");
        return trainerDao.update(trainer);
    }

    @Override
    public Trainer select(Long id) {
        log.info("select has been called");
        return trainerDao.select(id);
    }
}
