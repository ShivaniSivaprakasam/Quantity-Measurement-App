package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.Quantity;
import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.repository.IQuantityRepository;
import com.app.quantitymeasurement.unit.IMeasurable;

import java.util.List;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private final IQuantityRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityRepository repository) {
        this.repository = repository;
    }

    @Override
    public <T extends Enum<T> & IMeasurable> boolean compare(Quantity<T> q1, Quantity<T> q2) {
        return q1.equals(q2);
    }

    @Override
    public <T extends Enum<T> & IMeasurable> double convert(Quantity<T> quantity, T targetUnit) {
        return quantity.convertTo(targetUnit);
    }

    @Override
    public <T extends Enum<T> & IMeasurable> Quantity<T> add(Quantity<T> q1, Quantity<T> q2) {
        return q1.add(q2);
    }

    @Override
    public <T extends Enum<T> & IMeasurable> Quantity<T> subtract(Quantity<T> q1, Quantity<T> q2) {
        return q1.subtract(q2);
    }

    @Override
    public void saveMeasurement(QuantityMeasurementEntity entity) {
        repository.save(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {
        return repository.getAllMeasurements();
    }

    @Override
    public void deleteAllMeasurements() {
        repository.deleteAll();
    }

    @Override
    public long getTotalCount() {
        return repository.getTotalCount();
    }
}