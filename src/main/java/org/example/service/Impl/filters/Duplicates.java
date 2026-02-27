package org.example.service.Impl.filters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Trainee;
import org.example.domain.Trainer;
import org.example.domain.User;
import org.springframework.stereotype.Component;

import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@Component
public class Duplicates<T extends User> {
    private final Map<Long,Trainee> traineeMap;
    private final Map<Long,Trainer> trainerMap;

    public T searchDuplicates(T user) {
        log.info("Duplicates.searchDuplicates has been called");

        int serialNumber = 0;
        if (user instanceof Trainee) {
            for (Map.Entry<Long, Trainee> entry : traineeMap.entrySet()) {
                if (entry.getValue().getUserName().equals(user.getUserName())) {
                    serialNumber++;
                }
            }
        } else {
            for (Map.Entry<Long, Trainer> entry : trainerMap.entrySet()) {
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
