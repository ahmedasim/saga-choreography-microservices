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
