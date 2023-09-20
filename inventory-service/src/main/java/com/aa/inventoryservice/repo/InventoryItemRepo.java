package com.aa.inventoryservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.inventoryservice.entity.InventoryItemEntity;

@Repository
public interface InventoryItemRepo extends JpaRepository<InventoryItemEntity, Long> {

}
