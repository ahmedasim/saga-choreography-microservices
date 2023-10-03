package com.aa.purchasingservice.entity;

import java.util.List;

import com.aa.purchasingservice.dto.enums.ShipmentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
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
@Table(name = "pur_shipments", indexes = {
		@Index(name = "shipment_id_index", columnList = "shipmentId")
})
public class ShipmentEntity extends PurchasingBaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shipmentId;
	
	private String shipmentDate;
	
	@Enumerated(EnumType.STRING)
	private ShipmentStatus statusId;
	
	@OneToMany(mappedBy="shipment")
    private List<ShipmentItem> shipmentItems;

    
}
