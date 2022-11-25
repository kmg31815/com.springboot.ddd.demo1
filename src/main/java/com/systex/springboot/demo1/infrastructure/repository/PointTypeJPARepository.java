package com.systex.springboot.demo1.infrastructure.repository;

import com.systex.springboot.demo1.domain.PointType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PointTypeJPARepository extends JpaRepository<PointType, UUID> {
}
