package com.aa.purchasingservice.dto.response;

import java.math.BigDecimal;

import com.aa.purchasingservice.entity.ShipmentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentItemResponseDto {
	
	private Long shipmentItemId;
	private ShipmentEntity shipment;
	private BigDecimal shipmentQuantity;
	private BigDecimal shipmentCost;
}
