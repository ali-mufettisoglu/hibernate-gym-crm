package org.example.dao;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Trainer;
import org.example.persistence.GymMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class TrainerDaoImpl implements TrainerDao {
    private GymMap gymMap;

    @Value("${baseDirPath}")
    private String baseDirPath;

    @PostConstruct
    public void postConstruct() throws Exception {
        log.info("postConstruct is working");
        TrainerReader trainerReader = new TrainerReader();
        List<Trainer> list = trainerReader.read(this.baseDirPath + "/trainers.csv");
        list.forEach(this::create);
    }

    @Override
    public Trainer create(Trainer trainer) {
        log.info("create method is working");
        return gymMap.getGymMapTrainer().put(searchDuplicates(trainer).getUserId(), trainer);
    }

    public Trainer searchDuplicates(Trainer trainer) {
        int serialNumber = 0;
        for (Map.Entry<Long, Trainer> entry : gymMap.getGymMapTrainer().entrySet()) {
            String userName = entry.getValue().getFirstName() +"."+ entry.getValue().getLastName();
            if (userName.equals(trainer.getUserName())) {
                serialNumber++;
            }
        }
        if(serialNumber != 0) {
            trainer.setUserName(trainer.getUserName() + serialNumber);
        }
        return trainer;
    }

    @Override
    public Trainer update(Trainer trainer) {
        log.info("update method is working");
        return gymMap.getGymMapTrainer().put(trainer.getUserId(), trainer);
    }

    @Override
    public Trainer select(Long id) {
        log.info("select method is working");
        return gymMap.getGymMapTrainer().get(id);
    }

    @Autowired
    public void setGymMap(GymMap gymMap) {
        log.info("setter injection has done");
        this.gymMap = gymMap;
    }
}
