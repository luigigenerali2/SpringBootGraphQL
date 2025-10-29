package com.infoeste.codecash.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {
    @id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String document;

    @Column(nullable = false)
    private String password;

    @Column(name = "created_at", nullable = false)
    private String createdAt;
}
