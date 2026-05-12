package com.example.measurementservice.dto.quantity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuantityResponseDTO {

    private double resultValue;
    private String resultUnit;
}