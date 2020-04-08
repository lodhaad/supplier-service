package com.tradeai.supplierservice.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table (name = "supplier_profile", schema = "supply")

public class SupplierProfile {
	
	@Id
	@Column (name = "supplier_id")
	private String supplierId;
	
	@Column (name = "supplier_probablity")
	private Double supplyProbablity;

}
