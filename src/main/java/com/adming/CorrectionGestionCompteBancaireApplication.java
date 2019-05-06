package com.adming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.adming.metier.BanqueMetier;

@SpringBootApplication
public class CorrectionGestionCompteBancaireApplication {
	
	@Autowired
	private BanqueMetier banqueMetier;

	private static final Logger log = LoggerFactory.getLogger(CorrectionGestionCompteBancaireApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CorrectionGestionCompteBancaireApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CrudClient repositoryClient , 
			CrudCompte repositoryCompte, CrudOperation repositoryOperation) {
		return (args) -> {
			
		log.info("Demarrage");
		
		// Ajouter un client		
		Client cli1 = repositoryClient.save(new Client("Bernard"));
		Client cli2 = repositoryClient.save(new Client("Didier_Bernard"));
		Client cli3 = repositoryClient.save(new Client("Bernadette"));
		Client cli4 = repositoryClient.save(new Client("Bernardo"));
		
		// Consulter tous les clients
		System.out.println(repositoryClient.findAll());
		
		// Ajouter un compte
		Compte cpt1 = repositoryCompte.save(new CompteCourant ("ABC01" , 2000 , "21-01-2018", cli1 , 100));
		Compte cpt2 = repositoryCompte.save(new CompteCourant ("ABC02" , 20000 , "21-08-2018", cli2 , 50));
		Compte cpt3 = repositoryCompte.save(new CompteEpargne ("ABE01" , 1450 , "21-03-2018", cli3 , 2.05));
		Compte cpt4 = repositoryCompte.save(new CompteEpargne ("ABE02" , 14500 , "21-05-2018", cli1 , 2));
		
		// Consulter tous les comptes
		System.out.println(repositoryCompte.findAll());
		
		// Effectuer un retrait ou un versement sur un compte
//		Operation ope1 = repositoryOperation.save(new Retrait("22-02-2015", 150, cpt1));
//		Operation ope2 = repositoryOperation.save(new Retrait("22-04-2017", 750, cpt2));
//		Operation ope3 = repositoryOperation.save(new Versement("29-02-2005", 11450, cpt3));
//		Operation ope4 = repositoryOperation.save(new Versement("24-02-2016", 2, cpt4));
		
		// Consulter toutes les opérations
		System.out.println(repositoryOperation.findAll());
		
		// Sauvegarder les opérations des comptes
		repositoryCompte.save(cpt1);
		repositoryCompte.save(cpt2);
		repositoryCompte.save(cpt3);
		repositoryCompte.save(cpt4);
		
		// Consulter les comptes après les opérations
		System.out.println(repositoryCompte.findAll());
		
		// Consulter les clients dont le nom contient un mot-clé
		System.out.println(repositoryClient.findByNomContaining("Did"));
		// Consulter un compte
		System.out.println(repositoryCompte.findById("ABC02"));
		
		log.info("Terminer");
		
		log.info("Operations");
		
		banqueMetier.consulterCompte("ABC01");
		banqueMetier.consulterCompte("ABC02");
		
		System.out.println("Le compte ABC01 Avant versement : ");
		System.out.println(repositoryCompte.findById("ABC01"));
		banqueMetier.versement("ABC01", 500.0);
		System.out.println("Le compte ABC01 après versement : ");
		System.out.println(repositoryCompte.findById("ABC01"));
		banqueMetier.retrait("ABC02", 4500);
		banqueMetier.faireVirement("ABC02", "ABC01", 2000);
		banqueMetier.consulterCompte("ABC01");
		banqueMetier.consulterCompte("ABC02");
		
//		Compte monCompte = BanqueMetier.getCompte("ABC01");
//		log.info("comptes après opérations");
//		System.out.println();
		
		
		
		
		
		};
	}
}
