package com.github.jmariama.worm.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID; //universally unique identifier

@Entity //marks this as a class that will be used to create a record in the database
@Table(name = "users") // defines a table in db

//lombok taking care of generated setters and getters, aids in encapsulation.
@NoArgsConstructor
@AllArgsConstructor

@Data
@Builder //
public class UserEntity {

    @Id //defines primary key of this entity.
    @GeneratedValue(strategy = GenerationType.UUID) //auto generates primary keys.
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    private String email;

    private String userPassword;

    @Column(nullable = false) //null values not allowed
    private LocalDateTime created_at;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(userPassword, that.userPassword) && Objects.equals(created_at, that.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, userPassword, created_at);
    }
}