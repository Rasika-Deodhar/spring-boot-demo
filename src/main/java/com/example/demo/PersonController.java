package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/persons")
//@EnableAutoConfiguration
public class PersonController {

	@Autowired
	PersonService personService;
	
	@PostMapping
	public Person createPersonMethod(@RequestBody Person p) {
		
		//p = personService.createPerson(p);
		
		return personService.createPerson(p);
		
	}
	
	@GetMapping("/{id}")
	public Person getPersonMethod(@PathVariable Integer id) {
		
		Person p = personService.getPerson(id);
		return p;
		
	}
	
	@DeleteMapping("/{id}")
	public void deletePersonMethod(@PathVariable Integer id) {
		
		personService.deletePerson(id);
		
		//return personService.deletePerson(id);
		
	}
	
	@PutMapping("/{id}")
	public Person updatePersonMethod(@PathVariable Integer id,@RequestBody Person person) {
		
		//p = personService.deletePerson(p);
		
		return personService.updatePerson(id,person);
		
	}
	
	@GetMapping
	public List<Person> getAllPersons() {
		
		//PersonService personService = null;
		return personService.getAll();
	}
}

