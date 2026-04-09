package com.app.quantitymeasurement;

import com.app.quantitymeasurement.unit.IMeasurable;

public class Quantity<U extends Enum<U> & IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public double toBase() {
        return unit.toBaseUnit(value);
    }

    public double convertTo(U targetUnit) {
        double baseValue = this.toBase();
        return targetUnit.fromBaseUnit(baseValue);
    }

    public Quantity<U> add(Quantity<U> other) {
        checkArithmetic();
        double sum = this.toBase() + other.toBase();
        return new Quantity<>(unit.fromBaseUnit(sum), unit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        checkArithmetic();
        double diff = this.toBase() - other.toBase();
        return new Quantity<>(unit.fromBaseUnit(diff), unit);
    }

    public double divide(Quantity<U> other, U targetUnit) {
        checkArithmetic();
        double val1 = this.convertTo(targetUnit);
        double val2 = other.convertTo(targetUnit);
        return val1 / val2;
    }

    private void checkArithmetic() {
        if (!(unit instanceof SupportsArithmetic)) {
            throw new UnsupportedOperationException("Arithmetic not supported for this unit type");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;
        return Double.compare(this.toBase(), other.toBase()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toBase());
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}