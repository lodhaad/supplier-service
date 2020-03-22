package com.tradeai.supplierservice.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class SupplierAccountDTO {
	
	private String accountId;
	
	private String supplierId;
	
	private String accountName;
	
	private String accountDesc;
	
	private Date creationDate;

	private Date validFrom;
	
	private Date validTo;
	

}
