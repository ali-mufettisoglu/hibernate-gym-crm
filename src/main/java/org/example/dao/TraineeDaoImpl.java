package org.example.dao;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Trainee;
import org.example.persistence.GymMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class TraineeDaoImpl implements TraineeDao {
    private GymMap gymMap;

    @Value("${baseDirPath}")
    private String baseDirPath;

    @PostConstruct
    public void postConstruct() throws Exception {
        log.info("postConstruct is working");
        TraineeReader traineeReader = new TraineeReader();
        List<Trainee> list = traineeReader.read(this.baseDirPath + "/trainees.csv");
        list.forEach(this::create);
    }

    @Override
    public Trainee create(Trainee trainee) {
        log.info("create method is working");
        return gymMap.getGymMapTrainee().put(searchDuplicates(trainee).getUserId(), trainee);
    }

    public Trainee searchDuplicates(Trainee trainee) {
        int serialNumber = 0;
        for (Map.Entry<Long, Trainee> entry : gymMap.getGymMapTrainee().entrySet()) {
            String userName = entry.getValue().getFirstName() +"."+ entry.getValue().getLastName();
            if (userName.equals(trainee.getUserName())) {
                serialNumber++;
            }
        }
        if(serialNumber != 0) {
            trainee.setUserName(trainee.getUserName() + serialNumber);
        }
        return trainee;
    }

    @Override
    public Trainee update(Trainee trainee) {
        log.info("update method is working");
        return create(trainee);
    }

    @Override
    public Trainee delete(Long id) {
        log.info("remove method is working");
        return gymMap.getGymMapTrainee().remove(id);
    }

    @Override
    public Trainee select(Long id) {
        log.info("select method is working");
        return gymMap.getGymMapTrainee().get(id);
    }

    @Autowired
    public void setGymMap(GymMap gymMap) {
        log.info("setter injection has done");
        this.gymMap = gymMap;
    }

}
