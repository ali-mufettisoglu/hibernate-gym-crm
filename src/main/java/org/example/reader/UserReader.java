package org.example.reader;

import org.example.domain.Trainee;
import org.example.domain.Trainer;
import org.example.domain.Training;
import org.example.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserReader extends Reader {

    public List<User> read(String pathOfFile) {
        var lines = readFromFile(pathOfFile);
        return lines
                .stream()
                .map(i -> build(i, pathOfFile))
                .collect(Collectors.toList());
    }

    private User build(String line, String path) {
        var strings = splitLineByComma(line);
        if (path.contains("trainee")) {
            return new Trainee(
                    strings[0],
                    strings[1],
                    Boolean.parseBoolean(strings[2]),
                    strings[3],
                    strings[4],
                    Long.parseLong(strings[5]),
                    new Training(
                            Long.parseLong(strings[6]),
                            Long.parseLong(strings[7]),
                            strings[8],
                            strings[9],
                            strings[10],
                            strings[11],
                            Long.parseLong(strings[12])
                    )
            );
        } else {
            return new Trainer(
                    strings[0],
                    strings[1],
                    Boolean.parseBoolean(strings[2]),
                    strings[3],
                    Long.parseLong(strings[4])
            );
        }
    }
}
