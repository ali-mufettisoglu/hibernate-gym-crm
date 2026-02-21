package org.example;

import org.example.domain.Trainee;
import org.example.domain.Trainer;
import org.example.domain.Training;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@PropertySource(value = "classpath:application.properties")
@ComponentScan(basePackages = {"org.example"})
@Configuration
public class SpringConfig {

    @Bean(name = "traineeMap")
    public Map<Long, Trainee> traineeMap() {
        Map<Long, Trainee> traineeMap = new HashMap<>();
        return traineeMap;
    }

    @Bean(name = "trainerMap")
    public Map<Long, Trainer> trainerMap() {
        Map<Long, Trainer> trainerMap = new HashMap<>();
        return trainerMap;
    }

    @Bean(name = "trainingMap")
    public Map<Long, Training> trainingMap() {
        Map<Long, Training> trainingMap = new HashMap<>();
        return trainingMap;
    }
}

