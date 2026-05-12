package com.example.measurementservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "quantity_measurements")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuantityMeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_val", nullable = false, precision = 10, scale = 2)
    private BigDecimal firstValue;

    @Column(name = "first_unit", nullable = false)
    private String firstUnit;

    @Column(name = "second_val", nullable = false, precision = 10, scale = 2)
    private BigDecimal secondValue;

    @Column(name = "second_unit", nullable = false)
    private String secondUnit;

    @Column(name = "operation_type", nullable = false)
    private String operationType;

    @Column(name = "result_val", nullable = false, precision = 10, scale = 2)
    private BigDecimal resultValue;

    @Column(name = "result_unit", nullable = false)
    private String resultUnit;
}