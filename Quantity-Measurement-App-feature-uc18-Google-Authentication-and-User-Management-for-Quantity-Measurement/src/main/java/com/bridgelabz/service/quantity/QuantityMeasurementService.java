package com.bridgelabz.service.quantity;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.repository.IQuantityMeasurementRepository;
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