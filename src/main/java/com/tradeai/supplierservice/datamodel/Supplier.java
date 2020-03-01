package com.tradeai.supplierservice.datamodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "supplier", schema = "supply")

public class Supplier {
	
	@Id
	@Column (name = "supplier_id")
	private String supplierId;
	
	@Column (name = "supplier_name")
	private String supplierName;
	
	@Column (name = "supplier_type")
	private String supplierType;
	
	@Column (name = "supplier_doj")
	private Date supplierDateOfJoining;
	
	@Column (name = "supplier_eor")
	private Date supplierDateEndOfRelationship;
	
	@Column (name = "supplier_phone")
	private String supplierPhone;
	
	@Column (name = "supplier_email")
	private String supplierEmail;
	
	@OneToMany(mappedBy="relatedSupplier",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	
	private List<SupplierAccount> accounts = new ArrayList<>();
	
	
	
	 public List<SupplierAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<SupplierAccount> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(SupplierAccount account) {
		 accounts.add(account);
		 account.setRelatedSupplier(this);
	    }
	 
	    public void removeAccount(SupplierAccount account) {
	    	accounts.remove(account);
	        account.setRelatedSupplier(null);
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
