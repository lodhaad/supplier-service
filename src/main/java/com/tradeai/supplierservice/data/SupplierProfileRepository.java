package com.tradeai.supplierservice.data;

import org.springframework.data.repository.CrudRepository;

import com.tradeai.supplierservice.datamodel.SupplierProfile;

public interface SupplierProfileRepository extends CrudRepository<SupplierProfile, String> {

}
