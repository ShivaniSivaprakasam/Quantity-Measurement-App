package com.example.measurementservice.model;

public interface Measurable {
    @FunctionalInterface
    interface SupportsArithmetic {
        boolean isSupported();
    }

    default boolean supportsArithmetic() {
        return true;
    }

    default void validateOperationSupport(String operation) {
        // default: all operations allowed
    }
    double getConversionFactor();

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    String getUnitName();
}