package com.app.quantitymeasurement.repository;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;

import java.util.ArrayList;
import java.util.List;

public class QuantityRepositoryImpl implements IQuantityRepository {

    private final List<QuantityMeasurementEntity> records = new ArrayList<>();

    @Override
    public void save(QuantityMeasurementEntity entity) {
        records.add(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {
        return records;
    }

    @Override
    public void deleteAll() {
        records.clear();
    }

    @Override
    public long getTotalCount() {
        return records.size();
    }
}