package com.adming.metier;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adming.Compte;
import com.adming.CompteCourant;
import com.adming.CrudCompte;
import com.adming.CrudOperation;
import com.adming.Retrait;
import com.adming.Versement;
@Service
@Transactional
public class GestionBanque implements BanqueMetier {
	
	@Autowired
	private CrudCompte crudCompte;
	
	@Autowired 
	private CrudOperation crudOperation;

	@Override
	public Compte consulterCompte(String numCompte) {
		// TODO Auto-generated method stub
//		Optional<Compte> 
		Compte compte = crudCompte.findById(numCompte).get();
		
		return compte;
	}

	@Override
	public void versement(String numCompte, double montant) {
		
			Compte compte = consulterCompte(numCompte);
			Versement versement = new Versement("dateOperation", montant, compte);
			crudOperation.save(versement);
			
					
			compte.setSolde(compte.getSolde() + montant);
			crudCompte.save(compte);
		}

	@Override
	public void retrait(String numCompte, double montant) {
		// TODO Auto-generated method stub
		Compte compte = consulterCompte(numCompte);
		
		
		
		if (compte instanceof CompteCourant) {
		
		double droitDeRetrait = compte.getSolde() + ((CompteCourant) compte).getDecouvert();
		
		if (montant > droitDeRetrait) throw new RuntimeException("Solde Insuffisant");
		
		
		}		
		
		Retrait retrait = new Retrait("dateOperation", montant, compte);
		crudOperation.save(retrait);
		
				
		compte.setSolde(compte.getSolde() - montant);
		crudCompte.save(compte);
		
		
		
	}

	@Override
	public void faireVirement(String numCompteRetrait, String numCompteVersement, double montant) {
		// TODO Auto-generated method stub
		if(numCompteRetrait == numCompteVersement) throw new 
		RuntimeException("Impossible de faire un virement sur le même compte");
		
		retrait(numCompteRetrait, montant);
		versement(numCompteVersement, montant);
		
		
		
		
	}
	
	

}
