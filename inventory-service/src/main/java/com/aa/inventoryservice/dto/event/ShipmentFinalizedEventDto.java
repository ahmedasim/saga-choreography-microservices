package com.aa.inventoryservice.dto.event;

import com.aa.inventoryservice.dto.request.ShipmentItemRequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShipmentFinalizedEventDto extends BaseEvent {
	private ShipmentItemRequestDto eventDto;
	
	public ShipmentFinalizedEventDto(ShipmentItemRequestDto eventDto) {
		this.eventDto = eventDto;
	}
}
