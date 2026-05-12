package com.bridgelabz.service.quantity;

import com.bridgelabz.dto.quantity.QuantityRequestDTO;
import com.bridgelabz.dto.quantity.QuantityResponseDTO;

import java.util.List;

public interface IQuantityMeasurementService {

    boolean compare(QuantityRequestDTO request);

    QuantityResponseDTO add(QuantityRequestDTO request);

    List<QuantityResponseDTO> getAllResults();
}