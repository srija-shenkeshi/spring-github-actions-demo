package com.srija.springgithubactionsdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "account")
@EqualsAndHashCode(callSuper=false)
public class DB {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    Integer id;
    String userId;
    String username;
    String password;
    String email;
    int age;
    String gender;
    String occupation;

    public DB(String userId, String username, String password, String email, int age, String gender, String occupation, LocalDateTime creationTime, LocalDateTime lastUpdatedTime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.creationTime = creationTime;
        this.lastUpdatedTime = lastUpdatedTime;
    }

    LocalDateTime creationTime;
    LocalDateTime lastUpdatedTime;
}
