package com.tradeai.supplierservice.service;

import java.util.List;

import com.tradeai.supplierservice.datamodel.Supplier;
import com.tradeai.supplierservice.datamodel.SupplierAccount;
import com.tradeai.supplierservice.dto.SupplierAccountDTO;
import com.tradeai.supplierservice.dto.SupplierDTO;
import com.tradeai.supplierservice.dto.SupplierProfileDTO;

public interface SupplierService {
	
	public SupplierDTO getSupplier(String supplierId);
	
	public List<SupplierAccountDTO> getAllAccountsOfSupplier();
	
	public List<SupplierDTO> getSuppliers();
	
	public SupplierProfileDTO getSupplierProfile(String supplierId);

}
