package com.tradeai.supplierservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradeai.supplierservice.datamodel.Supplier;
import com.tradeai.supplierservice.datamodel.SupplierAccount;
import com.tradeai.supplierservice.dto.SupplierDTO;
import com.tradeai.supplierservice.service.SupplierService;
import com.tradeai.supplierservice.ui.model.request.SupplierRequest;
import com.tradeai.supplierservice.ui.model.response.SupplierAccountResponse;
import com.tradeai.supplierservice.ui.model.response.SupplierOnlyResponse;
import com.tradeai.supplierservice.ui.model.response.SupplierResponse;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService service;

	@GetMapping(path = "/{supplierId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SupplierOnlyResponse> getSupplier(@PathVariable String supplierId) {

		SupplierOnlyResponse response = getSupplierInformation(supplierId);

		return new ResponseEntity<SupplierOnlyResponse>(response, HttpStatus.OK);

	}

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SupplierOnlyResponse>> getSuppliers() {

		List<SupplierOnlyResponse> response = getAllSuppliersInfo();

		return new ResponseEntity<List<SupplierOnlyResponse>>(response, HttpStatus.OK);

	}

	private List<SupplierOnlyResponse> getAllSuppliersInfo() {

		List<SupplierOnlyResponse> response = new ArrayList<SupplierOnlyResponse>();

		List<SupplierDTO> supplier = service.getSuppliers();

		response = extractSupplierOnlyInformation(supplier);

		return response;

	}

	private List<SupplierOnlyResponse> extractSupplierOnlyInformation(List<SupplierDTO> suppliers) {

		List<SupplierOnlyResponse> response = new ArrayList<SupplierOnlyResponse>();

		for (SupplierDTO supplier : suppliers) {

			SupplierOnlyResponse responseElement = new SupplierOnlyResponse();

			responseElement.setSupplierId(supplier.getSupplierId());
			responseElement.setSupplierEmail(supplier.getSupplierEmail());
			responseElement.setSupplierPhone(supplier.getSupplierPhone());
			responseElement.setSupplierDateOfJoining(supplier.getSupplierDateOfJoining());
			responseElement.setSupplierType(supplier.getSupplierType());
			responseElement.setSupplierName(supplier.getSupplierName());
			response.add(responseElement);

		}
		return response;
	}

	private SupplierOnlyResponse getSupplierInformation(String supplierId) {

		SupplierDTO supplier = service.getSupplier(supplierId);

		SupplierOnlyResponse response = new SupplierOnlyResponse();

		response.setSupplierId(supplier.getSupplierId());
		response.setSupplierEmail(supplier.getSupplierEmail());
		response.setSupplierPhone(supplier.getSupplierPhone());
		response.setSupplierDateOfJoining(supplier.getSupplierDateOfJoining());
		response.setSupplierType(supplier.getSupplierType());
		response.setSupplierName(supplier.getSupplierName());

		return response;

	}

}
