package org.example.dao;

import org.example.domain.Training;

public interface TrainingDao {
    Training create(Training training);
    Training select(Long id);
}
