package com.app.quantitymeasurement.unit;

public interface IMeasurable {

    double toBaseUnit(double value);

    double fromBaseUnit(double baseValue);

    String getUnitName();
}

