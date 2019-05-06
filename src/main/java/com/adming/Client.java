package com.adming;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table (name = "t_client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long codeClient;
	private String nom;
	
	@OneToMany(mappedBy = "client", fetch=FetchType.LAZY)
	private Collection<Compte> comptes;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nom) {
		super();
	
		this.nom = nom;
	}

	public Long getCodeClient() {
		return codeClient;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "\nClient [codeClient=" + codeClient + ", nom=" + nom + "]";
	}
	
	
}
