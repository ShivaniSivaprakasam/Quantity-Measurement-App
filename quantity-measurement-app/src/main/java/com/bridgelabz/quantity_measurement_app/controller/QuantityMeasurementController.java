package com.bridgelabz.quantity_measurement_app.controller;

import com.bridgelabz.quantity_measurement_app.entity.QuantityMeasurementEntity;
import com.bridgelabz.quantity_measurement_app.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/measurements")
public class QuantityMeasurementController {

    private final IQuantityMeasurementService quantityMeasurementService;

    @Autowired
    public QuantityMeasurementController(IQuantityMeasurementService quantityMeasurementService) {
        this.quantityMeasurementService = quantityMeasurementService;
    }

    // Save Measurement
    @PostMapping
    public QuantityMeasurementEntity saveMeasurement(@RequestBody QuantityMeasurementEntity entity) {
        return quantityMeasurementService.saveMeasurement(entity);
    }

    // Get All
    @GetMapping
    public List<QuantityMeasurementEntity> getAllMeasurements() {
        return quantityMeasurementService.getAllMeasurements();
    }

    // Get By ID
    @GetMapping("/{id}")
    public Optional<QuantityMeasurementEntity> getMeasurementById(@PathVariable Long id) {
        return quantityMeasurementService.getMeasurementById(id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteMeasurement(@PathVariable Long id) {
        quantityMeasurementService.deleteMeasurementById(id);
        return "Deleted Successfully";
    }
}