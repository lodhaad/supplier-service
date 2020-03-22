package com.tradeai.supplierservice.datamodel;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;






@Entity
@Table (name = "account", schema = "supply")
public class SupplierAccount {
	
	@Id
	@Column (name = "acct_id")
	private String accountId;
	
	@Column (name = "supplier_id")
	private String supplierId;

	
	@Column (name = "acct_name")
	private String accountName;
	
	@Column (name = "acct_description")
	private String accountDesc;
	
	@Column (name = "acct_date_creation")
	private Date creationDate;
	
	@Column (name = "acct_valid_from")
	private Date validFrom;
	
	@Column (name = "acct_valid_to")
	private Date validTo;
	


	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	
	

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountDesc() {
		return accountDesc;
	}

	public void setAccountDesc(String accountDesc) {
		this.accountDesc = accountDesc;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}



	
	

}
