package com.devops.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    @DisplayName("Should return correct addition result")
    void testAdd() {
        assertThat(calculatorService.add(15, 25)).isEqualTo(40);
        assertThat(calculatorService.add(-5, 5)).isEqualTo(0);
    }

    @Test
    @DisplayName("Should return correct subtraction result")
    void testSubtract() {
        assertThat(calculatorService.subtract(50, 20)).isEqualTo(30);
    }

    @Test
    @DisplayName("Should return correct multiplication result")
    void testMultiply() {
        assertThat(calculatorService.multiply(6, 7)).isEqualTo(42);
    }

    @Test
    @DisplayName("Should return correct division result")
    void testDivide() {
        assertThat(calculatorService.divide(20, 4)).isEqualTo(5.0);
    }

    @Test
    @DisplayName("Should throw exception when dividing by zero")
    void testDivideByZero() {
        assertThatThrownBy(() -> calculatorService.divide(10, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Divider must not be zero");
    }

    @Test
    @DisplayName("Should format message using Commons Lang")
    void testFormatMessage() {
        assertThat(calculatorService.formatMessage("  devops gradle ci test  "))
                .isEqualTo("DEVOPS GRADLE CI TEST");
    }
}
