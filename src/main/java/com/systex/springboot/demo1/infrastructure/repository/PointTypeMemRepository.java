package com.systex.springboot.demo1.infrastructure.repository;

import com.systex.springboot.demo1.domain.PointType;
import com.systex.springboot.demo1.domain.common.repository.PointTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PointTypeMemRepository implements PointTypeRepository {
    List<PointType> typeList = new ArrayList<>();

    @Override
    public Optional<PointType> findById(UUID id) {
        for (PointType type : typeList) {
            if (type.getTypeId().equals(id)) {
                return Optional.ofNullable(type);
            }
        }
        return Optional.empty();
    }

    @Override
    public UUID save(PointType pointType) {
        PointType type = new PointType(UUID.randomUUID(), pointType.getType(), pointType.getDescription());
        typeList.add(type);
        return type.getTypeId();
    }

    @Override
    public List<PointType> getAll() {
        return typeList;
    }
}
