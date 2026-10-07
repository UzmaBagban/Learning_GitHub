package com.bugai.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Entity
@Table(name = "user_account")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant updatedAt;

    protected UserAccount() {
        // Required by JPA
    }

    // Controlled entity creation
    public UserAccount(String email, String passwordHash) {
        this.email = email;
        this.passwordHash = passwordHash;
    }
}
