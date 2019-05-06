package com.adming;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Cpte", discriminatorType = DiscriminatorType.STRING)
public abstract class Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	protected String numCompte;
	protected double solde;
	protected String date;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLIENT")
	private Client client;
	
	@OneToMany(mappedBy = "compte", fetch =FetchType.LAZY)
	private List<Operation> operations;
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(String numCompte, double solde, String date, Client client) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.date = date;
		this.client = client;
	}

	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "\nCompte [numCompte=" + numCompte + ", solde=" + solde + ", date=" + date + ", client=" + client
				+ ", operations=" + operations + "]";
	}

	
	
	
}
