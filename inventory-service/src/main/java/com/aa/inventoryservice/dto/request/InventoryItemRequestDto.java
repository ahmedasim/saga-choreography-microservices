package com.aa.commonservice.dto.inventoryservice.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItemRequestDto {
	private Long itemId;
    private String itemCode;
    private String itemName;
    private Integer statusId;
    private BigDecimal cost;
}
