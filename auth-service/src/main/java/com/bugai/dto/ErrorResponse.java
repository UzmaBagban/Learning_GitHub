package com.bugai.dto;

public record ErrorResponse(
        int status,
        String message
) {
}