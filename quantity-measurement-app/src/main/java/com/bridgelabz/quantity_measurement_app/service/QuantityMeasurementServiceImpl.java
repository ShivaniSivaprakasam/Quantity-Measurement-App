package com.bridgelabz.quantity_measurement_app.service;

import com.bridgelabz.quantity_measurement_app.entity.QuantityMeasurementEntity;
import com.bridgelabz.quantity_measurement_app.repository.QuantityMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private final QuantityMeasurementRepository quantityMeasurementRepository;

    @Autowired
    public QuantityMeasurementServiceImpl(QuantityMeasurementRepository quantityMeasurementRepository) {
        this.quantityMeasurementRepository = quantityMeasurementRepository;
    }

    @Override
    public QuantityMeasurementEntity saveMeasurement(QuantityMeasurementEntity entity) {
        return quantityMeasurementRepository.save(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {
        return quantityMeasurementRepository.findAll();
    }

    @Override
    public Optional<QuantityMeasurementEntity> getMeasurementById(Long id) {
        return quantityMeasurementRepository.findById(id);
    }

    @Override
    public void deleteMeasurementById(Long id) {
        quantityMeasurementRepository.deleteById(id);
    }
}