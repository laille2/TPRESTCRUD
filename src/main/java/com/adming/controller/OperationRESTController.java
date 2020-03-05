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
public class OperationRESTController {

	public OperationRESTController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private CrudOperation repositoryOperation;

	@RequestMapping("/o/")
	@ResponseBody
	public String welcome() {
		return "Welcome to RestTemplate Example.";
	}

	// URL: // http://localhost:8080/SomeContextPath/operations
	// http:// localhost:8080/SomeContextPath/operations.xml
	// http:// localhost:8080/SomeContextPath/operations.json

	@RequestMapping(value = "/operations", method = RequestMethod.GET, 
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  
    @ResponseBody 
    public List<Operation> getOperations() { 
		List<Operation> list = repositoryOperation.findAll(); 
		return list; 
    }

	// 
	// Ajout num 2
	// 
	
	// URL: // http://localhost:8080/SomeContextPath/operation/{codeoperation}
	// http:// localhost:8080/SomeContextPath/operation/{codeoperation}.xml // 
	// http:// localhost:8080/SomeContextPath/operation/{codeoperation}.json

	@RequestMapping(value="/operation/{codeOperation}", method = RequestMethod.GET,
	produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

	@ResponseBody 
	public Operation getOperation(@PathVariable("codeOperation") Long numOperation) {
	  return repositoryOperation.findByNumOperation(numOperation); 
	 }

	// URL: // http://localhost:8080/SomeContextPath/operation 
	// http:// localhost:8080/SomeContextPath/operation.xml 
	// http:// localhost:8080/SomeContextPath/operation.json

	@RequestMapping(value="/operation", method = RequestMethod.POST,
	produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

	@ResponseBody 
	public Operation addOperation(@RequestBody Operation operation) {
	  System.out.println("(Service Side) Création du operation numéro : " + operation.getNumOperation());
	  return repositoryOperation.save(operation);
	}

	// URL: // http://localhost:8080/SomeContextPath/employee // http://
	// localhost:8080/SomeContextPath/employee.xml // http://
	// localhost:8080/SomeContextPath/employee.json

	@RequestMapping(value="/operation", method = RequestMethod.PUT, 
	produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

	@ResponseBody
	public Operation updateOperation(@RequestBody Operation operation) {
		System.out.println("(Service Side) Modification du operation numéro : " + operation.getNumOperation());
		return repositoryOperation.save(operation);
	}

	// URL: // http://localhost:8080/SomeContextPath/operation/{codeoperation}

	@RequestMapping(value="/operation/{codeoperation}", method = RequestMethod.DELETE,
	produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

	@ResponseBody
	public void deleteEmployee(@PathVariable("codeOperation") Long numOperation) {

		System.out.println("(Service Side) Supression du operation numéro : " + numOperation);

		repositoryOperation.deleteById(numOperation);
	}
}
