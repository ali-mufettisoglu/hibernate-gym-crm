package org.example.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class Trainee extends User {
    private String userName;
    private String dateOfBirth;
    private String address;
    private Long userId;
    private Training training;

    public Trainee(String firstName, String lastName, boolean isActive,String dateOfBirth, String address, Long userId, Training training) {
        super(firstName, lastName, isActive);
        this.userName = firstName + "." + lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.userId = userId;
        this.training = training;
    }
}
