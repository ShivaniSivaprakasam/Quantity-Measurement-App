package com.bridgelabz.dto.quantity;

import lombok.*;

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