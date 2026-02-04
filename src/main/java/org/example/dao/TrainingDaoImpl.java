package org.example.dao;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Training;
import org.example.persistence.GymMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class TrainingDaoImpl implements TrainingDao{
    private GymMap gymMap;

    @Override
    public Training create(Training training) {
        log.info("create method is working");
        return gymMap.getGymMapTraining().put(training.getId(),training);
    }

    @Override
    public Training select(Long id) {
        log.info("select method is working");
        return gymMap.getGymMapTraining().get(id);
    }

    @Autowired
    public void setGymMap(GymMap gymMap) {
        log.info("setter injection has done");
        this.gymMap = gymMap;
    }
}
