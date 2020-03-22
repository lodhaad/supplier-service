package com.tradeai.supplierservice.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter



public class SupplierDTO {

	private String supplierId;

	private String supplierName;

	private String supplierType;

	private Date supplierDateOfJoining;

	private Date supplierDateEndOfRelationship;

	private String supplierPhone;

	private String supplierEmail;

}
