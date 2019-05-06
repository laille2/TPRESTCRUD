package com.adming.metier;

import java.util.Optional;

import com.adming.Compte;

public interface BanqueMetier {
	
	public Compte consulterCompte(String numCompte);
	public void versement (String numCompte, double montant);
	public void retrait (String numCompte, double montant);
	
	public void faireVirement (String numCompteRetrait, String numCompteVersement,
			double montant);
	

}
