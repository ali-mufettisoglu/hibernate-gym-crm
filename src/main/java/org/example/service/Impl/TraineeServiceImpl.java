package org.example.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TraineeDao;
import org.example.domain.Trainee;
import org.example.service.TraineeService;
import org.example.service.Impl.filters.Duplicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TraineeServiceImpl implements TraineeService {

    @Autowired
    private TraineeDao traineeDao;

    @Autowired
    private Duplicates<Trainee> duplicates;

    @Override
    public Trainee create(Trainee trainee) {
        log.info("create has been called");
        return traineeDao.create(duplicates.searchDuplicates(trainee));
    }

    @Override
    public Trainee update(Trainee trainee) {
        log.info("update has been called");
        return traineeDao.update(trainee);
    }

    @Override
    public Trainee delete(Long id) {
        log.info("delete has been called");
        return traineeDao.delete(id);
    }

    @Override
    public Trainee select(Long id) {
        log.info("select has been called");
        return traineeDao.select(id);
    }
}
