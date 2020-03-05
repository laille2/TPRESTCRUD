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
public class ClientRESTController {

	public ClientRESTController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private CrudClient repositoryClient;

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to RestTemplate Example.";
	}

	// URL: // http://localhost:8080/SomeContextPath/clients
	// http:// localhost:8080/SomeContextPath/clients.xml
	// http:// localhost:8080/SomeContextPath/clients.json

	@RequestMapping(value = "/clients", method = RequestMethod.GET, 
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  
    @ResponseBody 
    public List<Client> getClients() { 
		List<Client> list = repositoryClient.findAll(); 
		return list; 
    }

	// 
	// Ajout num 2
	// 
	
	// URL: // http://localhost:8080/SomeContextPath/client/{codeClient}
	// http:// localhost:8080/SomeContextPath/client/{codeClient}.xml // 
	// http:// localhost:8080/SomeContextPath/client/{codeClient}.json

	@RequestMapping(value="/client/{codeClient}", method = RequestMethod.GET,
	produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

	@ResponseBody 
	public Client getClient(@PathVariable("codeClient") Long codeClient) {
	  return repositoryClient.findByCodeClient(codeClient); 
	 }

	// URL: // http://localhost:8080/SomeContextPath/client 
	// http:// localhost:8080/SomeContextPath/client.xml 
	// http:// localhost:8080/SomeContextPath/client.json

	@RequestMapping(value="/client", method = RequestMethod.POST,
	produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

	@ResponseBody 
	public Client addClient(@RequestBody Client client) {
	  System.out.println("(Service Side) Création du client numéro : " + client.getCodeClient());
	  return repositoryClient.save(client);
	}

	// URL: // http://localhost:8080/SomeContextPath/employee // http://
	// localhost:8080/SomeContextPath/employee.xml // http://
	// localhost:8080/SomeContextPath/employee.json

	@RequestMapping(value="/client", method = RequestMethod.PUT, 
	produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

	@ResponseBody
	public Client updateClient(@RequestBody Client client) {
		System.out.println("(Service Side) Modification du client numéro : " + client.getCodeClient());
		return repositoryClient.save(client);
	}

	// URL: // http://localhost:8080/SomeContextPath/client/{codeClient}

	@RequestMapping(value="/client/{codeClient}", method = RequestMethod.DELETE,
	produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

	@ResponseBody
	public void deleteEmployee(@PathVariable("codeClient") Long codeClient) {

		System.out.println("(Service Side) Supression du client numéro : " + codeClient);

		repositoryClient.deleteById(codeClient);
	}

}
