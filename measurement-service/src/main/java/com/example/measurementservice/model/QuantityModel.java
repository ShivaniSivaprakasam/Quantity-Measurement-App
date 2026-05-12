package com.example.measurementservice.model;

import com.example.measurementservice.enums.LengthUnit;

public class QuantityModel {

    private Quantity<LengthUnit> quantity;

    public QuantityModel(double value, String unit) {

        LengthUnit unitEnum = LengthUnit.valueOf(unit); // 🔥 FIX

        this.quantity = new Quantity<>(value, unitEnum);
    }

    public Quantity<LengthUnit> getQuantity() {
        return quantity;
    }
}