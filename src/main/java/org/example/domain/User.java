package org.example.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean isActive;

    public User(String firstName, String lastName, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.password = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }

}
