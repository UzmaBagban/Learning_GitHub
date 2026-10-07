package com.bugai.repository;

import com.bugai.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAccountRepository extends JpaRepository<UserAccount, UUID> {
//Checking email exist or not
boolean existsByEmail(String email);
}
