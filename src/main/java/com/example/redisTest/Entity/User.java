package com.example.redisTest.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(name = "USER_NO", nullable = false)
    private Long userNo;

    private String username;

    private String password;

    public User() {
    }
}
