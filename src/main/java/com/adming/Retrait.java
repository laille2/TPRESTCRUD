package com.adming;

import javax.persistence.Entity;

@Entity
public class Retrait extends Operation {



	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait( String dateOperation, double montant, Compte compte) {
		super( dateOperation, montant, compte);
		compte.setSolde(compte.getSolde() - montant);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\nRetrait [numOperation=" + numOperation + ", dateOperation=" + dateOperation + ", montant=" + montant
				+ ", Compte =" + super.getCompte() + "]";
	}



	

	
}
