package org.example.dao.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TrainingDao;
import org.example.domain.Trainer;
import org.example.domain.Training;
import org.example.domain.User;
import org.example.reader.TrainingReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@Slf4j
@Component
public class TrainingDaoImpl implements TrainingDao {

    private Map<Long,Training> trainingMap;

    @Value("classpath:trainings.csv")
    private Resource resource;

    @Autowired
    private TrainingReader trainingReader;

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct is working");
        List<Training> list;
        try {
            list = trainingReader.read(resource.getFile().getPath());
        } catch (IOException e) {
            throw new RuntimeException("trainees file upload error, "+e);
        }
        list.forEach(this::create);
    }

    @Override
    public Training create(Training training) {
        log.info("create method is working");
        return trainingMap.put(training.getId(),training);
    }

    @Override
    public Training select(Long id) {
        log.info("select method is working");
        return trainingMap.get(id);
    }

    @Autowired
    public void setGymMap(Map<Long,Training> trainingMap) {
        log.info("setter injection has done");
        this.trainingMap = trainingMap;
    }
}
