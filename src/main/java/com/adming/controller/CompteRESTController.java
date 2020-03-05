package com.adming.controller;

import java.util.List;

import com.adming.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompteRESTController {

	public CompteRESTController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private CrudCompte repositoryCompte;

	@RequestMapping("/c/")
	@ResponseBody
	public String welcome() {
		return "Welcome to RestTemplate Example.";
	}

	// URL: // http://localhost:8080/SomeContextPath/comptes
	// http:// localhost:8080/SomeContextPath/comptes.xml
	// http:// localhost:8080/SomeContextPath/comptes.json

	@RequestMapping(value = "/comptes", method = RequestMethod.GET, 
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  
    @ResponseBody 
    public List<Compte> getComptes() { 
		List<Compte> list = repositoryCompte.findAll(); 
		return list; 
    }

	// 
	// Ajout num 2
	// 
	
	// URL: // http://localhost:8080/SomeContextPath/compte/{codecompte}
	// http:// localhost:8080/SomeContextPath/compte/{codecompte}.xml // 
	// http:// localhost:8080/SomeContextPath/compte/{codecompte}.json

	@RequestMapping(value="/compte/{codecompte}", method = RequestMethod.GET,
	produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

	@ResponseBody 
	public Compte getCompte(@PathVariable("codecompte") String numCompte) {
	  return repositoryCompte.findByNumCompte(numCompte); 
	 }

	// URL: // http://localhost:8080/SomeContextPath/compte 
	// http:// localhost:8080/SomeContextPath/compte.xml 
	// http:// localhost:8080/SomeContextPath/compte.json

	@RequestMapping(value="/compte", method = RequestMethod.POST,
	produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

	@ResponseBody 
	public Compte addCompte(@RequestBody Compte compte) {
	  System.out.println("(Service Side) Création du compte numéro : " + compte.getNumCompte());
	  return repositoryCompte.save(compte);
	}

	// URL: // http://localhost:8080/SomeContextPath/employee // http://
	// localhost:8080/SomeContextPath/employee.xml // http://
	// localhost:8080/SomeContextPath/employee.json

	@RequestMapping(value="/compte", method = RequestMethod.PUT, 
	produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

	@ResponseBody
	public Compte updateCompte(@RequestBody Compte compte) {
		System.out.println("(Service Side) Modification du compte numéro : " + compte.getNumCompte());
		return repositoryCompte.save(compte);
	}

	// URL: // http://localhost:8080/SomeContextPath/compte/{codecompte}

	@RequestMapping(value="/compte/{codecompte}", method = RequestMethod.DELETE,
	produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

	@ResponseBody
	public void deleteEmployee(@PathVariable("codecompte") String numCompte) {

		System.out.println("(Service Side) Supression du compte numéro : " + numCompte);

		repositoryCompte.deleteById(numCompte);
	}
}
