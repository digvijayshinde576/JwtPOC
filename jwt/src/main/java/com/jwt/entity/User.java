package com.jwt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@NoArgsConstructor
@Table(name = "UserTable")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username ;
    private String password;
    private String email;

    public User(int id, String username, String password, String email) {
        this.id=id;
        this.username=username;
        this.password=password;
        this.email=email;
    }
}
