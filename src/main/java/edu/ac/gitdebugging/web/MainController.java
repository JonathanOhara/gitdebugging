package edu.ac.gitdebugging.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Iterable<Person>> findAll() {
		return new ResponseEntity<Iterable<Person>>( personService.findAll(), HttpStatus.OK );
	}
	
	@PostMapping
	public ResponseEntity<Person> save(Person person) {
		return new ResponseEntity<Person>( personService.insert(person), HttpStatus.CREATED );
	}
	
	@GetMapping("/{personId}")
	public ResponseEntity<Person> findOne(@PathVariable("personId") Long id) {
		return new ResponseEntity<Person>( personService.findOne(id), HttpStatus.OK );
	}
	
	@PutMapping("/{personId}")
	public ResponseEntity<Person> update(@PathVariable("personId") Long id, @RequestBody Person person) {
		person.setId(id);
		return new ResponseEntity<Person>( personService.update(person), HttpStatus.OK );
	}
	
	public ResponseEntity<Person> personNotFound() {
		return new ResponseEntity<Person>( HttpStatus.NOT_FOUND );
	}
}
