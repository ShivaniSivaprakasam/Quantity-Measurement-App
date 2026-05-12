package com.example.measurementservice.service.quantity;

import com.example.measurementservice.dto.quantity.QuantityRequestDTO;
import com.example.measurementservice.dto.quantity.QuantityResponseDTO;

import java.util.List;

public interface IQuantityMeasurementService {

    boolean compare(QuantityRequestDTO request);

    QuantityResponseDTO add(QuantityRequestDTO request);

    List<QuantityResponseDTO> getAllResults();
}