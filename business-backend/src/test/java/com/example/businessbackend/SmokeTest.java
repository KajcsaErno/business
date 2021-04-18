package com.example.businessbackend;

import com.example.businessbackend.controllers.BusinessController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class SmokeTest {
    @Autowired
    private BusinessController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
