package org.example.dao;

import org.example.domain.Trainer;

public interface TrainerDao {
    Trainer create(Trainer trainer);
    Trainer update(Trainer trainer);
    Trainer select(Long id);
}
