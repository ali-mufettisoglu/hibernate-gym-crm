package org.example.domain;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@ToString(callSuper = true)
public class Trainee extends User {
    private String dateOfBirth;
    private String address;
    private Long userId;

    public Trainee(String firstName, String lastName, boolean isActive,String dateOfBirth, String address, Long userId) {
        super(firstName, lastName, isActive);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.userId = userId;
    }


}
