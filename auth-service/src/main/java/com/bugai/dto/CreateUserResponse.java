package com.bugai.dto;

import java.util.UUID;

public record CreateUserResponse(
        UUID userId,
        String email
) {
}