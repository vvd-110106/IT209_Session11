package com.devops.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AppTest {

    @Test
    @DisplayName("Main method should execute without exceptions")
    void testMain() {
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
}
