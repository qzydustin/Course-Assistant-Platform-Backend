package com.hat.cap.entityDatabase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;


@Entity
@NoArgsConstructor(force = true)
@Getter
@Setter
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    public Instructor(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
