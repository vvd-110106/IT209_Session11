package com.devops.demo;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

public class CalculatorService {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        Preconditions.checkArgument(b != 0, "Divider must not be zero");
        return (double) a / b;
    }

    public String formatMessage(String message) {
        return StringUtils.trimToEmpty(message).toUpperCase();
    }
}
