package com.aa.purchasingservice.dto.event;

import com.aa.purchasingservice.dto.request.ShipmentRequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShipmentFinalizedEventDto extends BaseEvent {
	private ShipmentRequestDto eventDto;
	
	public ShipmentFinalizedEventDto(ShipmentRequestDto eventDto) {
		this.eventDto = eventDto;
	}
}
