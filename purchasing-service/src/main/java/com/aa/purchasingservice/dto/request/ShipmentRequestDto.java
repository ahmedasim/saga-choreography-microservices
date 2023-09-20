package com.aa.purchasingservice.dto.request;

import java.util.Date;
import java.util.List;

import com.aa.purchasingservice.dto.enums.ShipmentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentRequestDto {
	
	private Long shipmentId;
	private Date shipmentDate;
    private ShipmentStatus statusId;
    List<ShipmentItemRequestDto> shipmentItems;
}
