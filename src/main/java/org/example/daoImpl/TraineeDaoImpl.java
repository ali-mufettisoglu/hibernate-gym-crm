package org.example.daoImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TraineeDao;
import org.example.domain.Trainee;
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
public class TraineeDaoImpl implements TraineeDao {
    private GymMap gymMap;

    @Value("${baseDirPath}/trainees.csv")
    private String baseDirPath;

    @PostConstruct
    public void postConstruct() throws Exception {
        log.info("postConstruct is working");
        UserReader reader = new UserReader();
        List<User> list = reader.read(this.baseDirPath);
        list.forEach(e -> create((Trainee) e));
    }

    @Override
    public Trainee create(Trainee trainee) {
        log.info("create method is working");
        System.out.println(trainee);
        return gymMap.getGymMapTrainee().put(trainee.getUserId(), trainee);
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
