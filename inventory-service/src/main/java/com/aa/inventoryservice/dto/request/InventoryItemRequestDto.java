package com.aa.inventoryservice.dto.request;

import java.math.BigDecimal;

import com.aa.inventoryservice.dto.enums.InventoryItemStatus;

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
    private InventoryItemStatus statusId;
    private BigDecimal quantity;
    private BigDecimal cost;
}
