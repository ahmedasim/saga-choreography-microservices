package com.aa.purchasingservice.dto.response;

import java.util.List;

import com.aa.purchasingservice.dto.request.ShipmentItemRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentResponseDto {
	
	private Long shipmentId;
	private String shipmentDate;
    private Integer statusId;
    List<ShipmentItemRequestDto> shipmentItems;
}
