package com.tradeai.supplierservice.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tradeai.supplierservice.datamodel.SupplierAccount;

@Repository
public interface SupplierAccountRepository extends CrudRepository<SupplierAccount, String> {
	



}
