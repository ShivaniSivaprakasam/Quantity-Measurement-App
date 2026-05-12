package com.bridgelabz.enums;

import com.bridgelabz.model.Measurable;

public enum TemperatureUnit implements Measurable {

    CELSIUS,
    FAHRENHEIT;

    @Override
    public double convertToBaseUnit(double value) {
        if (this == CELSIUS)
            return value;

        if (this == FAHRENHEIT)
            return (value - 32) * 5 / 9;

        return value;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        if (this == CELSIUS)
            return baseValue;

        if (this == FAHRENHEIT)
            return (baseValue * 9 / 5) + 32;

        return baseValue;
    }

    @Override
    public double getConversionFactor() {
        return 1.0;
    }

    @Override
    public String getUnitName() {
        return this.name();
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
                "Temperature does not support " + operation + " operation"
        );
    }

    @Override
    public boolean supportsArithmetic() {
        return false;
    }
}