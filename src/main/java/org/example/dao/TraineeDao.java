package org.example.dao;

import org.example.domain.Trainee;

public interface TraineeDao {
    Trainee create(Trainee trainee);
    Trainee update(Trainee trainee);
    Trainee delete(Long id);
    Trainee select(Long id);
}
