package com.tradeai.supplierservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradeai.supplierservice.data.SupplierAccountRepository;
import com.tradeai.supplierservice.data.SupplierRepository;
import com.tradeai.supplierservice.datamodel.Supplier;
import com.tradeai.supplierservice.datamodel.SupplierAccount;
import com.tradeai.supplierservice.dto.SupplierAccountDTO;
import com.tradeai.supplierservice.dto.SupplierDTO;
import com.tradeai.supplierservice.dto.SupplierProfileDTO;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository repository;

	@Autowired
	private SupplierAccountRepository supplyAccountRepository;

	@Override
	public SupplierDTO getSupplier(String supplierId) {

		Supplier supplier = repository.findById(supplierId).get();

		ModelMapper mapper = new ModelMapper();
		SupplierDTO dto = mapper.map(supplier, SupplierDTO.class);

		return dto;
	}

	@Override
	public List<SupplierDTO> getSuppliers() {

		List<SupplierDTO> listOfSuppliers = new ArrayList<>();

		Iterable<Supplier> iterable = repository.findAll();

		iterable.forEach(element -> {

			ModelMapper mapper = new ModelMapper();
			SupplierDTO dto = mapper.map(element, SupplierDTO.class);
			listOfSuppliers.add(dto);

		});

		return listOfSuppliers;
	}

	@Override
	public List<SupplierAccountDTO> getAllAccountsOfSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierProfileDTO getSupplierProfile(String supplierId) {
		// TODO Auto-generated method stub
		return null;
	}

}
