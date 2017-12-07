package edu.ac.gitdebugging.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ac.gitdebugging.domain.Person;
import edu.ac.gitdebugging.service.PersonService;

@RestController
@RequestMapping("/persons") 
public class MainController {

	@Autowired
	private PersonService personService;
	
	@GetMapping
	public Iterable<Person> findAll() {
		return personService.findAll();
	}
	
	@PostMapping
	public Person save(Person person) {
		return personService.save(person);
	}
	
}
