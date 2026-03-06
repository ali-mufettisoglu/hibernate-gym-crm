package org.example.dao.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TrainerDao;
import org.example.domain.Trainee;
import org.example.domain.Trainer;
import org.example.domain.User;
import org.example.reader.UserReader;
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
public class TrainerDaoImpl implements TrainerDao {

    private Map<Long,Trainer> trainerMap;

    @Value("classpath:trainers.csv")
    Resource resource;

    @Autowired
    UserReader userReader;

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct is working");
        List<User> list;
        try {
            list = userReader.read(resource.getFile().getPath());
        } catch (IOException e) {
            throw new RuntimeException("trainees file upload error, "+e);
        }
        list.forEach(e -> create((Trainer) e));
    }

    @Override
    public Trainer create(Trainer trainer) {
        log.info("create method is working");
        return trainerMap.put(trainer.getUserId(), trainer);
    }

    @Override
    public Trainer update(Trainer trainer) {
        log.info("update method is working");
        return trainerMap.put(trainer.getUserId(), trainer);
    }

    @Override
    public Trainer select(Long id) {
        log.info("select method is working");
        return trainerMap.get(id);
    }

    @Autowired
    public void setGymMap(Map<Long,Trainer> trainerMap) {
        log.info("setter injection has done");
        this.trainerMap = trainerMap;
    }
}
