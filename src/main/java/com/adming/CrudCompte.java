package com.adming;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CrudCompte extends CrudRepository<Compte, String>{

	Compte findByNumCompte(String numCompte);
	List<Compte> findAll ();

}
