package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	private static List<Person> PersonList;
	@Autowired
	PersonRepository personRepository;

	public PersonService() {
		PersonList = new ArrayList<>();
		PersonList.add(new Person("Test", 23));
		PersonList.add(new Person("Rasika", 22));
	}

	public Person getPerson(String name) {

		for (Person person : PersonList) {
			if (person.getName().equals(name)) {
				return person;
			}
		}
		return null;
	}

	public Person getPerson(Integer id) {
		return personRepository.findById(id).get();

	}

	public Person createPerson(Person p) {

		// PersonList.add(p);
		// return p;
		Person person = personRepository.save(p);
		return person;
	}

	public Person deletePerson(String name) {
		System.out.println("Remove " + name);
		Person p = getPerson(name);
		System.out.println("Remove " + p);
		if (p != null) {
			PersonList.remove(p);
			System.out.println("Removed");
			return p;
		} else
			return null;
	}

	public void deletePerson(Integer id) {
		personRepository.deleteById(id);
	}

	public List<Person> getAll() {

		// return PersonList;
		return personRepository.findAll();
	}

	public Person updatePerson(String name, Person person1) {

		for (Person person : PersonList) {
			if (person.getName().equals(name)) {
				person.setName(person1.getName());
				person.setAge(person1.getAge());
				return person;
			}
		}

		return null;
	}

	public Person updatePerson(Integer id, Person p) {
		p.setId(id);
		return personRepository.save(p);
	}
}
