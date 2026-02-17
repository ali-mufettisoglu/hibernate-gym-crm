package org.example.daoImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TrainerDao;
import org.example.domain.Trainer;
import org.example.domain.User;
import org.example.persistence.GymMap;
import org.example.reader.UserReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Component
public class TrainerDaoImpl implements TrainerDao {
    private GymMap gymMap;

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
        System.out.println(trainer);
        return gymMap.getGymMapTrainer().put(trainer.getUserId(), trainer);
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
