package org.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.persistence.GymMap;
import org.example.service.TraineeService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Application {
    private final TraineeService traineeService;
    private final GymMap gymMap;

    public void run() {
        log.info("Application running");
    }
}
