package com.adming;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CrudClient extends CrudRepository<Client, Long>{

	List<Client> findByNomContaining (String nom);
	
}
