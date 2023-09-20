package com.aa.inventoryservice.dto.request;

import java.util.Date;
import java.util.List;

import com.aa.inventoryservice.dto.enums.ShipmentStatus;

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
