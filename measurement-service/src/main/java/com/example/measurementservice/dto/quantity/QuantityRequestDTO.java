package com.example.measurementservice.dto.quantity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityRequestDTO {

    private double firstValue;
    private String firstUnit;

    private double secondValue;
    private String secondUnit;

    private String operation;
}