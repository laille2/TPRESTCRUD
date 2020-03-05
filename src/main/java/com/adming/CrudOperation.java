package com.adming;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CrudOperation extends CrudRepository<Operation, Long>{

	Operation findByNumOperation(Long numOperation);
	List<Operation> findAll ();
}
