package com.app.quantitymeasurement;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.repository.IQuantityRepository;
import com.app.quantitymeasurement.repository.QuantityMeasurementDatabaseRepository;
import com.app.quantitymeasurement.service.QuantityMeasurementServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        IQuantityRepository repository =
                new QuantityMeasurementDatabaseRepository();

        QuantityMeasurementServiceImpl service =
                new QuantityMeasurementServiceImpl(repository);

        System.out.println("Quantity Measurement App Started");

        // Test Save
        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
        entity.setOperation("ADD");
        entity.setMeasurementType("LENGTH");
        entity.setValue1(10);
        entity.setUnit1("FEET");
        entity.setValue2(12);
        entity.setUnit2("INCH");
        entity.setResult(11);
        entity.setCreatedAt(LocalDateTime.now());

        service.saveMeasurement(entity);

        System.out.println("Measurement saved successfully");

        // Test Get All
        List<QuantityMeasurementEntity> list =
                service.getAllMeasurements();

        System.out.println("Total records : " + list.size());

        // Test Count
        System.out.println("Count : " + service.getTotalCount());

    }
}