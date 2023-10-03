package com.aa.inventoryservice.entity;

import java.math.BigDecimal;

import com.aa.inventoryservice.dto.enums.InventoryItemStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "inv_items", indexes = {
		@Index(name = "item_id_index", columnList = "itemId"),
		@Index(name = "item_code_index", columnList = "itemCode", unique = true)
}, uniqueConstraints = {
		@UniqueConstraint(name="item_name_unique", columnNames = {"itemName"})
})
public class InventoryItemEntity extends InventoryBaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	private String itemCode;
    private String itemName;
    @Enumerated(EnumType.STRING)
    private InventoryItemStatus statusId;
    private BigDecimal quantity;
    private BigDecimal cost;

}
