package com.example.measurementservice.service.quantity;

import com.example.measurementservice.entity.QuantityMeasurementEntity;
import com.example.measurementservice.repository.IQuantityMeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;

    public QuantityMeasurementService(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    public QuantityMeasurementEntity save(QuantityMeasurementEntity entity) {
        return repository.save(entity);
    }

    public List<QuantityMeasurementEntity> getAll() {
        return repository.findAll();
    }
}