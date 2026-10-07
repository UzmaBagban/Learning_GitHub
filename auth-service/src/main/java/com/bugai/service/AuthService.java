package com.bugai.service;



import com.bugai.dto.*;
import com.bugai.entity.UserAccount;
import com.bugai.exception.EmailAlreadyRegisteredException;
import com.bugai.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserAccountRepository userAccountRepository;
/*
This is being cerated by @RequiredArgsConstructor  it works with final fields only.
We are doing Constructor Injection
 public AuthService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }
 */
private final PasswordEncoder passwordEncoder;

    public CreateUserResponse register(CreateUserRequest request) {

        if (userAccountRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyRegisteredException("Email already registered");
        }

        String passwordHash =
                passwordEncoder.encode(request.password());

        UserAccount userAccount =
                new UserAccount(request.email(), passwordHash);

        UserAccount savedUser =
                userAccountRepository.save(userAccount);

        return new CreateUserResponse(
                savedUser.getId(),
                savedUser.getEmail()
        );
    }
}
