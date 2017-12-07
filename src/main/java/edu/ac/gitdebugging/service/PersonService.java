package edu.ac.gitdebugging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ac.gitdebugging.domain.Person;
import edu.ac.gitdebugging.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public Iterable<Person> findAll(){
		return personRepository.findAll();
	}
	
	public Person save(Person person){
		return personRepository.save(person);
	}
}
