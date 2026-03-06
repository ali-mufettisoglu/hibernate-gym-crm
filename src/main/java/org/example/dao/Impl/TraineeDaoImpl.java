package org.example.dao.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TraineeDao;
import org.example.domain.Trainee;
import org.example.domain.User;

import org.example.reader.UserReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class TraineeDaoImpl implements TraineeDao {

    private Map<Long,Trainee> traineeMap;

    @Value("classpath:trainees.csv")
    private Resource resource;

    @Autowired
    private UserReader userReader;

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct is working");
        List<User> list;
        try {
            list = userReader.read(resource.getFile().getPath());
        } catch (IOException e) {
            throw new RuntimeException("trainees file upload error, "+e);
        }
        list.forEach(e -> create((Trainee) e));
    }

    @Override
    public Trainee create(Trainee trainee) {
        log.info("create method is working");
        return traineeMap.put(trainee.getUserId(), trainee);
    }

    @Override
    public Trainee update(Trainee trainee) {
        log.info("update method is working");
        return create(trainee);
    }

    @Override
    public Trainee delete(Long id) {
        log.info("remove method is working");
        return traineeMap.remove(id);
    }

    @Override
    public Trainee select(Long id) {
        log.info("select method is working");
        return traineeMap.get(id);
    }

    @Autowired
    public void setGymMap(Map<Long,Trainee> traineeMap) {
        log.info("setter injection has done");
        this.traineeMap = traineeMap;
    }

}
