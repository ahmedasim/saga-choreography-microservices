package com.aa.purchasingservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.purchasingservice.entity.ShipmentEntity;

@Repository
public interface ShipmentRepo extends JpaRepository<ShipmentEntity, Long> {

}
