package org.example.dao.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TrainerDao;
import org.example.domain.Trainer;
import org.example.domain.User;
import org.example.reader.UserReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class TrainerDaoImpl implements TrainerDao {

    private Map<Long,Trainer> trainerMap;

    @Value("${baseDirPath}/trainers.csv")
    private String baseDirPath;

    @PostConstruct
    public void postConstruct() throws Exception {
        log.info("postConstruct is working");
        UserReader reader = new UserReader();
        List<User> list = reader.read(this.baseDirPath);
        list.forEach(i -> create((Trainer) i));
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
