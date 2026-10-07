package com.bugai.controller;

import com.bugai.dto.*;
import com.bugai.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/*import com.bugai.dto.HealthResponse;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @GetMapping("/health")
    public HealthResponse health() {
        return new HealthResponse("UP");
    }} */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<CreateUserResponse> register(
            @Valid @RequestBody CreateUserRequest clientRequest) {

        CreateUserResponse response =
                authService.register(clientRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
