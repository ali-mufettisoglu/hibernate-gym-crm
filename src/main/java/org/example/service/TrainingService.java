package org.example.service;

import org.example.domain.Training;

public interface TrainingService {
    Training create(Training training);
    Training select(Long id);
}
