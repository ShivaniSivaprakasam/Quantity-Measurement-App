package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.Quantity;
import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.unit.IMeasurable;

import java.util.List;

public interface IQuantityMeasurementService {

    <T extends Enum<T> & IMeasurable> boolean compare(Quantity<T> q1, Quantity<T> q2);

    <T extends Enum<T> & IMeasurable> double convert(Quantity<T> quantity, T targetUnit);

    <T extends Enum<T> & IMeasurable> Quantity<T> add(Quantity<T> q1, Quantity<T> q2);

    <T extends Enum<T> & IMeasurable> Quantity<T> subtract(Quantity<T> q1, Quantity<T> q2);

    void saveMeasurement(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> getAllMeasurements();

    void deleteAllMeasurements();

    long getTotalCount();
}