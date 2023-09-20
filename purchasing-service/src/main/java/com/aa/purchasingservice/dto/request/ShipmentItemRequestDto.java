package com.aa.purchasingservice.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentItemRequestDto {
	
	private Long shipmentItemId;
	private Long shipmentId;
	private BigDecimal shipmentQuantity;
	private BigDecimal shipmentCost;
}
