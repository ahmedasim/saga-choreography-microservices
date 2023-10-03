package com.aa.purchasingservice.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentRequestDto {
	
	private Long shipmentId;
	private String shipmentDate;
    private Integer statusId;
    List<ShipmentItemRequestDto> shipmentItems;
}
