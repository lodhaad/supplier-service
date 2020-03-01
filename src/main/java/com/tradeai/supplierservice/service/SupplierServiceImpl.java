package com.tradeai.supplierservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradeai.supplierservice.data.SupplierAccountRepository;
import com.tradeai.supplierservice.data.SupplierRepository;
import com.tradeai.supplierservice.datamodel.Supplier;



@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierRepository repository;
	
	@Autowired
	private SupplierAccountRepository supplyAccountRepository;

	@Override
	public Supplier getSupplier(String supplierId) {

		return repository.findById(supplierId).get();
	}

	@Override
	public List<Supplier> getSuppliers() {

		List<Supplier> listOfSuppliers = new ArrayList<>();
		
		Iterable<Supplier> iterable = repository.findAll();
		
		iterable.forEach(listOfSuppliers::add);
				
		
		return listOfSuppliers;
	}

}
