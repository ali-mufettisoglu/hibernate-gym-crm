package org.example.service;

import org.example.domain.Trainer;

public interface TrainerService {
    Trainer create(Trainer trainer);
    Trainer update(Trainer trainer);
    Trainer select(Long id);
}
