package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Trainer extends User {
    private String specialization;
    private Long userId;

    public Trainer(String firstName, String lastName, boolean isActive,String specialization, Long userId) {
        super(firstName, lastName, isActive);
        this.specialization = specialization;
        this.userId = userId;
    }
}
