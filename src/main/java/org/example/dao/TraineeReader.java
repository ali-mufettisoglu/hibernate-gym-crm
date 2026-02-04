package org.example.dao;

import org.example.domain.Trainee;
import org.example.domain.User;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TraineeReader extends Reader {

    @Override
    public List<Trainee> read(String path) {
        var lines = readFromFile(path);
        return lines
                .stream()
                .map(this::buildTrainee)
                .collect(Collectors.toList());
    }

    private Trainee buildTrainee(String line) {
        var strings = splitLineByComma(line);
        var userId = Long.parseLong(strings[5]);
        return new Trainee(
                strings[0],
                strings[1],
                Boolean.parseBoolean(strings[2]),
                strings[3],
                strings[4],
                userId);
    }
}
