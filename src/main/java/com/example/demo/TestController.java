package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
//@EnableAutoConfiguration
public class TestController {

	PersonService personService = new PersonService();
	
	
	@GetMapping("/hello")
	public String testMethod() {
		return "Hello!";
	}
	
	@GetMapping("/hello_spring")
	public String testMethod1() {
		return "Hello Spring!";
	}
	
	@PutMapping("/hello")
	public Person putMethod(@RequestBody Person p) {
		System.out.println("Request body for Name.");
		//p.setName("Raj");
		
		System.out.println("Request body for Age.");
		//p.setAge(40);
		
		//System.out.println();
		System.out.println(p.toString());
		return p;
	}
	
	@PostMapping
	public Person createPersonMethod(@RequestBody Person p) {
		
		//p = personService.createPerson(p);
		
		return personService.createPerson(p);
		
	}
	
	@GetMapping("/{name}")
	public Person getPersonMethod(@PathVariable String name) {
		
		Person p = personService.getPerson(name);
		if(p!=null && p.getName().equals(name))
		return p;
		else
			System.out.println("Person with this name does not exist!");
		return null;
		
	}
	
	@DeleteMapping("/{name}")
	public Person deletePersonMethod(@PathVariable String name) {
		
		//p = personService.deletePerson(p);
		
		return personService.deletePerson(name);
		
	}
	
	@PutMapping("/{name}")
	public Person updatePersonMethod(@PathVariable String name,@RequestBody Person person) {
		
		//p = personService.deletePerson(p);
		
		return personService.updatePerson(name,person);
		
	}
	
	@GetMapping
	public List<Person> getAllPersons() {
		
		//PersonService personService = null;
		return personService.getAll();
	}
}

