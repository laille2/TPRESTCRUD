package com.adming;

import javax.persistence.Entity;

@Entity
public class Versement extends Operation {

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement( String dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
//		compte.setSolde(compte.getSolde() + montant);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\nVersement [numOperation=" + numOperation + ", dateOperation=" + dateOperation + ", montant=" + montant
				+ ", Compte =" + super.getCompte() + "]";
	}



}
