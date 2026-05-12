package com.example.measurementservice.controller;

import com.example.measurementservice.dto.quantity.QuantityRequestDTO;
import com.example.measurementservice.dto.quantity.QuantityResponseDTO;
import com.example.measurementservice.service.quantity.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quantity")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    // ✅ ADD API
    @PostMapping("/add")
    public QuantityResponseDTO add(@RequestBody QuantityRequestDTO request) {
        return service.add(request);
    }

    // ✅ COMPARE API
    @PostMapping("/compare")
    public boolean compare(@RequestBody QuantityRequestDTO request) {
        return service.compare(request);
    }

    // ✅ GET ALL RESULTS
    @GetMapping("/results")
    public List<QuantityResponseDTO> getAllResults() {
        return service.getAllResults();
    }
}