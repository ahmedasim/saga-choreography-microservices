package com.aa.purchasingservice.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentResponseDto {
	private Long itemId;
    private String itemCode;
    private String itemName;
    private Integer statusId;
    private BigDecimal cost;
}
