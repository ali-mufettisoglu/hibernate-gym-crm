package org.example.reader;

import org.example.domain.Training;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainingReader extends Reader {
    public List<Training> read(String path) {
        var lines = readFromFile(path);
        return lines
                .stream()
                .map(this::buildTraining)
                .collect(Collectors.toList());
    }

    private Training buildTraining(String line) {
        var strings = splitLineByComma(line);
        return new Training(
                Long.parseLong(strings[0]),
                Long.parseLong(strings[1]),
                strings[2],
                strings[3],
                strings[4],
                strings[5],
                Long.parseLong(strings[6])
        );
    }
}
