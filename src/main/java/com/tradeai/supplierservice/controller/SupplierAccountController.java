package com.tradeai.supplierservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradeai.supplierservice.datamodel.Supplier;
import com.tradeai.supplierservice.datamodel.SupplierAccount;
import com.tradeai.supplierservice.dto.SupplierAccountDTO;
import com.tradeai.supplierservice.dto.SupplierDTO;
import com.tradeai.supplierservice.service.SupplierService;
import com.tradeai.supplierservice.ui.model.response.SupplierAccountResponse;
import com.tradeai.supplierservice.ui.model.response.SupplierResponse;

@RestController
@RequestMapping("/supplier/{supplierId}/account")

public class SupplierAccountController {

	@Autowired
	private SupplierService service;
	

	@GetMapping(path = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SupplierResponse> getSupplierBasedOnSupplierIdAndAccount(
			@PathVariable("supplierId") String supplierId, @PathVariable("accountId") String accountId) {

		SupplierResponse response = getSuppliersOnSupplierId(supplierId);

		return new ResponseEntity<SupplierResponse>(response, HttpStatus.OK);

	}

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SupplierResponse> getSupplierAndAllAccount(@PathVariable("supplierId") String supplierId) {

		SupplierResponse response = getSuppliersOnSupplierId(supplierId);

		return new ResponseEntity<SupplierResponse>(response, HttpStatus.OK);

	}

	private SupplierResponse getSuppliersOnSupplierId(String supplierId) {

		SupplierDTO supplier = service.getSupplier(supplierId);

		List<SupplierAccountDTO> accounts = service.getAllAccountsOfSupplier();

		List<SupplierAccountResponse> accountResponse = extract(accounts);

		SupplierResponse response = new SupplierResponse();

		response.setAccounts(accountResponse);
		response.setSupplierId(supplier.getSupplierId());
		response.setSupplierEmail(supplier.getSupplierEmail());
		response.setSupplierPhone(supplier.getSupplierPhone());
		response.setSupplierDateOfJoining(supplier.getSupplierDateOfJoining());
		response.setSupplierType(supplier.getSupplierType());
		response.setSupplierName(supplier.getSupplierName());

		return response;

	}

	private List<SupplierAccountResponse> extract(List<SupplierAccountDTO> accounts) {

		List<SupplierAccountResponse> list = new ArrayList<>();

		for (SupplierAccountDTO account : accounts) {

			SupplierAccountResponse response = new SupplierAccountResponse();
			response.setAccountId(account.getAccountId());
			list.add(response);

		}

		return list;
	}

}
