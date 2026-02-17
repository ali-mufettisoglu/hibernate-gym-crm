package org.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.facade.GymCrmFacade;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Application {
    private final GymCrmFacade gymCrmFacade;

    public void run() {
        log.info("Application running");
        gymCrmFacade.createTraining();
    }
}
