package org.example.reader;

import org.example.domain.Trainer;

import java.util.List;
import java.util.stream.Collectors;

public class TrainerReader extends Reader {

    @Override
    public List<Trainer> read(String path) {
        var lines = readFromFile(path);
        return lines
                .stream()
                .map(this::buildTrainer)
                .collect(Collectors.toList());
    }

    private Trainer buildTrainer(String line) {
        var strings = splitLineByComma(line);
        var userId = Long.parseLong(strings[4]);
        return  new Trainer (
                strings[0],
                strings[1],
                Boolean.parseBoolean(strings[2]),
                strings[3],
                userId
        );
    }
}
