package com.adming;

import javax.persistence.Entity;

@Entity
public class CompteCourant extends Compte{

	private double decouvert;

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CompteCourant(String numCompte, double solde, String date, Client client, double decouvert) {
		super(numCompte, solde, date, client);
		this.decouvert = decouvert;
	}



	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}



	@Override
	public String toString() {
		return "\nCompteCourant [decouvert=" + decouvert + 
				", numCompte=" + numCompte + ", solde=" + solde + ", date="
				+ date + ",Client = " + super.getClient() + "]";
	}




	
	
}
