package com.aa.purchasingservice.dto.event;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;

@Getter
public abstract class BaseEvent {

	protected UUID eventId = UUID.randomUUID();
	protected Date eventDate = new Date();
}
