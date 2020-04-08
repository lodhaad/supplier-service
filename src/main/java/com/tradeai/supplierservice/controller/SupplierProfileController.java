package com.tradeai.supplierservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier-profile")
public class SupplierProfileController {
	
	@GetMapping("/health")
	public String healthCheck() {
		return "hello supplier-profile";
		
	}
	
	@GetMapping("/{supplierId}")
	public String getProfileForSupplier(@PathVariable String supplierId) {
		
		return null;
		
	}

}
