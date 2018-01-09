package edu.ac.gitdebugging.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{personId}")
	public Person findOne(@PathVariable("personId") Long id) {
		return personService.findOne(id);
	}
	
	@PutMapping("/{personId}")
	public Person update(@PathVariable("personId") Long id, @RequestBody Person person) {
		person.setId(id);
		return personService.save(person);
	}
}
