package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Training {
    private Long traineeId;
    private Long trainerId;
    private String name;
    private Type type;
    private String date;
    private String duration;
    private Long id;
}
