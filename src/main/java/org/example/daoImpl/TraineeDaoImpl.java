package org.example.daoImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.TraineeDao;
import org.example.domain.Trainee;
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
public class TraineeDaoImpl implements TraineeDao {

    private Map<Long,Trainee> traineeMap;

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
