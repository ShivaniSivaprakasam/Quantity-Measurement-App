package com.bridgelabz.service.quantity;

import com.bridgelabz.enums.LengthUnit;
import com.bridgelabz.model.Quantity;
import com.bridgelabz.dto.quantity.QuantityRequestDTO;
import com.bridgelabz.dto.quantity.QuantityResponseDTO;
import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.repository.IQuantityMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Autowired
    private IQuantityMeasurementRepository repository;

    // ✅ COMPARE
    @Override
    @Transactional
    public boolean compare(QuantityRequestDTO request) {

        LengthUnit unit1 = LengthUnit.valueOf(request.getFirstUnit());
        LengthUnit unit2 = LengthUnit.valueOf(request.getSecondUnit());

        Quantity<LengthUnit> qty1 = new Quantity<>(request.getFirstValue(), unit1);
        Quantity<LengthUnit> qty2 = new Quantity<>(request.getSecondValue(), unit2);

        boolean result = qty1.equals(qty2);

        // Save to DB
        QuantityMeasurementEntity entity = QuantityMeasurementEntity.builder()
                .firstValue(BigDecimal.valueOf(request.getFirstValue()))
                .firstUnit(request.getFirstUnit())
                .secondValue(BigDecimal.valueOf(request.getSecondValue()))
                .secondUnit(request.getSecondUnit())
                .operationType("COMPARE")
                .resultValue(BigDecimal.valueOf(result ? 1 : 0))
                .resultUnit("BOOLEAN")
                .build();

        repository.save(entity);

        return result;
    }

    // ✅ ADD
    @Override
    @Transactional
    public QuantityResponseDTO add(QuantityRequestDTO request) {

        LengthUnit unit1 = LengthUnit.valueOf(request.getFirstUnit());
        LengthUnit unit2 = LengthUnit.valueOf(request.getSecondUnit());

        Quantity<LengthUnit> qty1 = new Quantity<>(request.getFirstValue(), unit1);
        Quantity<LengthUnit> qty2 = new Quantity<>(request.getSecondValue(), unit2);

        Quantity<LengthUnit> result = qty1.add(qty2);

        double resultValue = result.getValue();

        // Save to DB
        QuantityMeasurementEntity entity = QuantityMeasurementEntity.builder()
                .firstValue(BigDecimal.valueOf(request.getFirstValue()))
                .firstUnit(request.getFirstUnit())
                .secondValue(BigDecimal.valueOf(request.getSecondValue()))
                .secondUnit(request.getSecondUnit())
                .operationType("ADD")
                .resultValue(BigDecimal.valueOf(resultValue))
                .resultUnit(request.getFirstUnit())
                .build();

        repository.save(entity);

        // Return DTO
        return QuantityResponseDTO.builder()
                .resultValue(resultValue)
                .resultUnit(request.getFirstUnit())
                .build();
    }

    // ✅ GET ALL RESULTS
    @Override
    public List<QuantityResponseDTO> getAllResults() {

        return repository.findAll()
                .stream()
                .map(entity -> QuantityResponseDTO.builder()
                        .resultValue(entity.getResultValue().doubleValue())
                        .resultUnit(entity.getResultUnit())
                        .build())
                .collect(Collectors.toList());
    }
}