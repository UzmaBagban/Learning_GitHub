package com.bugai.auth.controller;

import com.bugai.controller.AuthController;
import com.bugai.dto.HealthResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthControllerTest {

    @Test
    void healthTest() {

        AuthController controller = new AuthController();

        HealthResponse response = controller.health();

        assertEquals("UP", response.status());
    }
}