package com.aa.purchasingservice.entity;

import java.math.BigDecimal;

import com.aa.purchasingservice.dto.enums.ShipmentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
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
		@Index(name = "item_code_index", columnList = "itemCode", unique = true),
		@Index(name = "category_id_index", columnList = "categoryId")
}, uniqueConstraints = {
		@UniqueConstraint(name="item_name_unique", columnNames = {"itemName"})
})
public class ShipmentEntity extends PurchasingBaseEntity {
	
	@Id
	@GeneratedValue
	private Long itemId;
	private String itemCode;
    private String itemName;
    @Enumerated(EnumType.STRING)
    private ShipmentStatus statusId;
    private BigDecimal cost;

}
