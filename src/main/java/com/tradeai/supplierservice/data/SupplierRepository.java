package com.tradeai.supplierservice.data;

import org.springframework.data.repository.CrudRepository;

import com.tradeai.supplierservice.datamodel.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, String>{

}
