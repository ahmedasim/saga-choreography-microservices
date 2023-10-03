package com.aa.purchasingservice.dto.response;

import java.util.Date;
import java.util.List;

import com.aa.purchasingservice.dto.enums.ShipmentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentResponseDto {
	
	private Long shipmentId;
	private Date shipmentDate;
    private ShipmentStatus statusId;
    List<ShipmentItemResponseDto> shipmentItems;
}
