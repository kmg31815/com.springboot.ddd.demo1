package com.systex.springboot.demo1.domain.common.repository;

import com.systex.springboot.demo1.domain.PointType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PointTypeRepository {
    Optional<PointType> findById(UUID id);

    UUID save(PointType pointType);

    List<PointType> getAll();
}
