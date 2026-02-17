package org.example.serviceImpl.filters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Trainee;
import org.example.domain.Trainer;
import org.example.domain.User;
import org.example.persistence.GymMap;
import org.springframework.stereotype.Component;

import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@Component
public class Duplicates<T extends User> {
    private final GymMap gymMap;

    public T searchDuplicates(T user) {
        log.info("Duplicates.searchDuplicates has been called");

        int serialNumber = 0;
        if (user instanceof Trainee) {
            for (Map.Entry<Long, Trainee> entry : gymMap.getGymMapTrainee().entrySet()) {
                if (entry.getValue().getUserName().equals(user.getUserName())) {
                    serialNumber++;
                }
            }
        } else {
            for (Map.Entry<Long, Trainer> entry : gymMap.getGymMapTrainer().entrySet()) {
                if (entry.getValue().getUserName().equals(user.getUserName())) {
                    serialNumber++;
                }
            }
        }
        if (serialNumber != 0) {
            user.setUserName(user.getUserName() + serialNumber);
        }

        return user;
    }
}
