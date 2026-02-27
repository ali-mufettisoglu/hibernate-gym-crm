package org.example.dao.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TrainingDao;
import org.example.domain.Training;
import org.example.reader.TrainingReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;


@Slf4j
@Component
public class TrainingDaoImpl implements TrainingDao {

    private Map<Long,Training> trainingMap;

    @Value("${baseDirPath}/trainings.csv")
    private String baseDirPath;

    @PostConstruct
    public void postConstruct() throws Exception {
        log.info("postConstruct is working");
        TrainingReader reader = new TrainingReader();
        List<Training> list = reader.read(this.baseDirPath);
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
