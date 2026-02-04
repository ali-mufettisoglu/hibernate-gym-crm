package org.example.service;

import org.example.domain.Trainee;

public interface TraineeService {
    Trainee create(Trainee trainee);
    Trainee update(Trainee trainee);
    Trainee delete(Long id);
    Trainee select(Long id);
}
