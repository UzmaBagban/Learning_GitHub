package com.bugai.auth.controller;

import com.bugai.controller.AuthController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
public class AuthControllerMvcTest {

    @Autowired
    private MockMvc mockMvc; // Good practice: make fields private

    @Test
    void health_shouldReturnUp() throws Exception {
        mockMvc.perform(
                        get("/api/v1/auth/health")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }
}
