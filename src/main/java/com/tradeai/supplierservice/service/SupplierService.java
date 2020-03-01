package com.tradeai.supplierservice.service;

import java.util.List;

import com.tradeai.supplierservice.datamodel.Supplier;

public interface SupplierService {
	
	public Supplier getSupplier(String supplierId);
	public List<Supplier> getSuppliers();

}
