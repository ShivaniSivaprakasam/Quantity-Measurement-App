package com.bridgelabz.quantity_measurement_app.service;

import com.bridgelabz.quantity_measurement_app.entity.QuantityMeasurementEntity;

import java.util.List;
import java.util.Optional;

public interface IQuantityMeasurementService {

    QuantityMeasurementEntity saveMeasurement(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> getAllMeasurements();

    Optional<QuantityMeasurementEntity> getMeasurementById(Long id);

    void deleteMeasurementById(Long id);
}