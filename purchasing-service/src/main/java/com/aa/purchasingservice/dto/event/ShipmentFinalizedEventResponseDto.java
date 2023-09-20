package com.aa.purchasingservice.dto.event;

import com.aa.purchasingservice.dto.enums.ShipmentStatus;
import com.aa.purchasingservice.dto.request.ShipmentRequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShipmentFinalizedEventResponseDto extends BaseEvent {
	private ShipmentRequestDto eventDto;
	private String errorMessage;
	private ShipmentStatus status;
	
	public ShipmentFinalizedEventResponseDto(ShipmentRequestDto eventDto, ShipmentStatus status, String errorMessage) {
		this.eventDto = eventDto;
		this.status = status;
		this.errorMessage = errorMessage;
	}
}
