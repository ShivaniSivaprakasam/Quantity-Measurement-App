package com.bridgelabz.dto.quantity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuantityResponseDTO {

    private double resultValue;
    private String resultUnit;
}