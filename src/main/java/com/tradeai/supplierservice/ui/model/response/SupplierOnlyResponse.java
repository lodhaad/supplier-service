package com.tradeai.supplierservice.ui.model.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class SupplierOnlyResponse {
	
	private String supplierId;
	private String supplierName;
	private String supplierType;
	private Date supplierDateOfJoining; 
	private Date supplierDateEndOfRelationship;
	private String supplierPhone;
	private String supplierEmail;

}
