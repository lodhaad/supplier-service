package com.tradeai.supplierservice.ui.model.response;

import java.util.Date;
import java.util.List;

public class SupplierResponse {
	
	private String supplierId;
	private String supplierName;
	private String supplierType;
	private Date supplierDateOfJoining; 
	private Date supplierDateEndOfRelationship;
	private String supplierPhone;
	private String supplierEmail;
	
	private List<SupplierAccountResponse> accounts;
	
	
	
	public List<SupplierAccountResponse> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<SupplierAccountResponse> accounts) {
		this.accounts = accounts;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierType() {
		return supplierType;
	}
	public void setSupplierType(String supplierType) {
		this.supplierType = supplierType;
	}
	public Date getSupplierDateOfJoining() {
		return supplierDateOfJoining;
	}
	public void setSupplierDateOfJoining(Date supplierDateOfJoining) {
		this.supplierDateOfJoining = supplierDateOfJoining;
	}
	public Date getSupplierDateEndOfRelationship() {
		return supplierDateEndOfRelationship;
	}
	public void setSupplierDateEndOfRelationship(Date supplierDateEndOfRelationship) {
		this.supplierDateEndOfRelationship = supplierDateEndOfRelationship;
	}
	public String getSupplierPhone() {
		return supplierPhone;
	}
	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}
	public String getSupplierEmail() {
		return supplierEmail;
	}
	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	} 
	
	
	

}
