package com.adming;

import javax.persistence.Entity;

@Entity
public class CompteEpargne extends Compte {

	private double tauxInteret;

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CompteEpargne(String numCompte, double solde, String date, Client client, double tauxInteret) {
		super(numCompte, solde, date, client);
		this.tauxInteret = tauxInteret;
	}



	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}



	@Override
	public String toString() {
		return "\nCompteEpargne [tauxInteret=" + tauxInteret + ", numCompte=" + numCompte + ", solde=" + solde + ", date="
				+ date + ",Client = " + super.getClient() +  "]";
	}



	

	
	
}
