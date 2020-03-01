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
import com.tradeai.supplierservice.service.SupplierService;
import com.tradeai.supplierservice.ui.model.request.SupplierRequest;
import com.tradeai.supplierservice.ui.model.response.SupplierAccountResponse;
import com.tradeai.supplierservice.ui.model.response.SupplierOnlyResponse;
import com.tradeai.supplierservice.ui.model.response.SupplierResponse;

@RestController
@RequestMapping ("/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierService service;
	
	
	@GetMapping (path ="/{supplierId}", produces = MediaType.APPLICATION_JSON_VALUE , 
			consumes = MediaType.APPLICATION_JSON_VALUE  )
	public ResponseEntity<SupplierOnlyResponse> getSupplier(@PathVariable String supplierId){
		
		SupplierOnlyResponse response = getSupplierOnlyFromDB(supplierId);
		
		return new ResponseEntity<SupplierOnlyResponse>(response, HttpStatus.OK);
		
	}
	
	
	
	@GetMapping (path ="", produces = MediaType.APPLICATION_JSON_VALUE , 
			consumes =MediaType.APPLICATION_JSON_VALUE  )
	public ResponseEntity<List<SupplierOnlyResponse>> getSuppliers(){
		
		
		
		
		List<SupplierOnlyResponse> response = getSuppliersFromDB();

		
		return new ResponseEntity<List<SupplierOnlyResponse>>(response, HttpStatus.OK);
		
	}
	
	
	@GetMapping (path ="/{supplierId}/account/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE , 
			consumes = MediaType.APPLICATION_JSON_VALUE  )
	public ResponseEntity<SupplierResponse> getSupplierBasedOnSupplierIdAndAccount(@PathVariable("supplierId") String supplierId,
	@PathVariable ("accountId") String accountId){
		
		SupplierResponse response = getSupplierFromDB(supplierId);
		
		return new ResponseEntity<SupplierResponse>(response, HttpStatus.OK);
		
	}
	
	
	@GetMapping (path ="/{supplierId}/account", produces = MediaType.APPLICATION_JSON_VALUE , 
			consumes = MediaType.APPLICATION_JSON_VALUE  )
	public ResponseEntity<SupplierResponse> getSupplierAndAllAccount(@PathVariable("supplierId") String supplierId ){
		
		SupplierResponse response = getSupplierFromDB(supplierId);
		

		return new ResponseEntity<SupplierResponse>(response, HttpStatus.OK);
		
	}
	
	
	private SupplierResponse getSupplierFromDB(String supplierId) {
		
		
		Supplier supplier = service.getSupplier(supplierId);
		

		List<SupplierAccount> accounts = supplier.getAccounts();
		
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
	
	
	private List<SupplierOnlyResponse> getSuppliersFromDB() {
		
		List<SupplierOnlyResponse> response = new ArrayList<SupplierOnlyResponse>();
		
		List<Supplier> supplier = service.getSuppliers();
		
		response = extractSupplierOnlyInformation(supplier);


		
		return response;
		
	}
	
	





	private List<SupplierOnlyResponse> extractSupplierOnlyInformation(List<Supplier> suppliers) {
		
		
		List<SupplierOnlyResponse> response = new ArrayList<SupplierOnlyResponse>();
		
		for (Supplier supplier : suppliers) {
			
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



	private List<SupplierAccountResponse> extract (List<SupplierAccount> dbAccount){
		
		List<SupplierAccountResponse> list = new ArrayList<>();
		
		
		
		for (SupplierAccount account : dbAccount) {
			
			SupplierAccountResponse response = new SupplierAccountResponse();
			response.setAccountId(account.getAccountId());
			list.add(response);
			
		}
		
		return list;
	}
	
	
private SupplierOnlyResponse getSupplierOnlyFromDB(String supplierId) {
		
		
		Supplier supplier = service.getSupplier(supplierId);
		
	
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
