package com.app.quantitymeasurement.repository;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.exception.DatabaseException;
import com.app.quantitymeasurement.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementDatabaseRepository implements IQuantityRepository {

    private final ConnectionPool connectionPool;

    public QuantityMeasurementDatabaseRepository() {
        this.connectionPool = new ConnectionPool();
    }

    @Override
    public void save(QuantityMeasurementEntity entity) {
        String sql = "INSERT INTO quantity_measurement " +
                "(operation, measurement_type, value1, unit1, value2, unit2, result, created_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, entity.getOperation());
            statement.setString(2, entity.getMeasurementType());
            statement.setDouble(3, entity.getValue1());
            statement.setString(4, entity.getUnit1());
            statement.setDouble(5, entity.getValue2());
            statement.setString(6, entity.getUnit2());
            statement.setDouble(7, entity.getResult());
            statement.setTimestamp(8, Timestamp.valueOf(entity.getCreatedAt()));

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Error saving measurement", e);
        }
    }

    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {
        List<QuantityMeasurementEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM quantity_measurement";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

                entity.setId(resultSet.getLong("id"));
                entity.setOperation(resultSet.getString("operation"));
                entity.setMeasurementType(resultSet.getString("measurement_type"));
                entity.setValue1(resultSet.getDouble("value1"));
                entity.setUnit1(resultSet.getString("unit1"));
                entity.setValue2(resultSet.getDouble("value2"));
                entity.setUnit2(resultSet.getString("unit2"));
                entity.setResult(resultSet.getDouble("result"));
                entity.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());

                list.add(entity);
            }

        } catch (SQLException e) {
            throw new DatabaseException("Error retrieving measurements", e);
        }

        return list;
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM quantity_measurement";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Error deleting measurements", e);
        }
    }

    @Override
    public long getTotalCount() {
        String sql = "SELECT COUNT(*) FROM quantity_measurement";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getLong(1);
            }

        } catch (SQLException e) {
            throw new DatabaseException("Error counting measurements", e);
        }

        return 0;
    }
}