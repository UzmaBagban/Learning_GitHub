package com.bugai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String email;

    private String passwordHash;
}
