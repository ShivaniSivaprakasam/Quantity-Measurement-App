CREATE TABLE IF NOT EXISTS quantity_measurement (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    operation VARCHAR(50),
    measurement_type VARCHAR(50),
    value1 DOUBLE,
    unit1 VARCHAR(50),
    value2 DOUBLE,
    unit2 VARCHAR(50),
    result DOUBLE,
    created_at TIMESTAMP
);