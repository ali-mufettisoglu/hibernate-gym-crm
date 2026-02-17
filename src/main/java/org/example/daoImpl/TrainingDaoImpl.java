package org.example.daoImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TrainingDao;
import org.example.domain.Training;
import org.example.persistence.GymMap;
import org.example.reader.TrainingReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Slf4j
@Component
public class TrainingDaoImpl implements TrainingDao {
    private GymMap gymMap;

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
