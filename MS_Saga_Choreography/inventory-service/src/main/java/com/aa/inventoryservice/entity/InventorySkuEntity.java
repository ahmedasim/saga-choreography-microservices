package com.aa.inventoryservice.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "inv_skus")
public class InventorySkuEntity extends InventoryBaseEntity {
	private Long skuId;
	private Long itemId;
    private String sku;
    //private String barcode;
    private Integer statusId;
    private BigDecimal reorderQuantityThreshold; 
    private BigDecimal reorderQuantity; 
    private BigDecimal maximumReorderQuantity;
    private Long siteId;
    private Long categoryId;
}
