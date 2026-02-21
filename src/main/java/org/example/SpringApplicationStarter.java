package org.example;

import org.example.facade.GymCrmFacadeImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplicationStarter {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class)) {
            GymCrmFacadeImpl gymCrmFacade = applicationContext.getBean(GymCrmFacadeImpl.class);
            gymCrmFacade.createTraining();
        }
    }
}