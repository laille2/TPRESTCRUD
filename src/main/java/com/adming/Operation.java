package com.adming;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Op", discriminatorType =DiscriminatorType.STRING)
public abstract class Operation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	protected Long numOperation;
	protected String dateOperation;
	protected double montant;
	
	@ManyToOne
	@JoinColumn(name = "Code_Cpt")
	private Compte compte;
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operation( String dateOperation, double montant, Compte compte) {
		super();
		
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
	}

	
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Long getNumOperation() {
		return numOperation;
	}

	public String getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(String dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "Operation [numOperation=" + numOperation + ", dateOperation=" + dateOperation + ", montant=" + montant
				+ ", Compte =" + compte + "]";
	}
	
	
}
