package com.aa.inventoryservice.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "inv_items")
public class InventoryItemEntity extends InventoryBaseEntity {
	private Long itemId;
    private String itemCode;
    private String binNumber;
    private String itemName;
    private String itemDescription;
    private Integer statusId;
    private Long siteId;
    private Long categoryId;
    private Long packagingId;
    private Long defaultVendorId;
    private Long inventoryAccountId;
    private Long costOfGoodSoldAccountId;
    private Long expenseAccountId;
    private Long costAdjustmentAccountId;
    private String itemShortDescription;
    private String vendorShortDescription;
    private String itemDescriptionForConnect;
    private BigDecimal worth;

}
