package com.aa.purchasingservice.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "pur_shipment_items", indexes = {
		@Index(name = "shipment_item_id_index", columnList = "shipmentItemId"),
		@Index(name = "shipment_id_index", columnList = "shipment_id")
})
public class ShipmentItem extends PurchasingBaseEntity  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shipmentItemId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="shipment_id", nullable=false, referencedColumnName = "shipmentId")
	private ShipmentEntity shipment;
	
	private BigDecimal shipmentQuantity;
	private BigDecimal shipmentCost;

}
