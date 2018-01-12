package edu.ac.gitdebugging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ac.gitdebugging.domain.Person;
import edu.ac.gitdebugging.exception.PersonNotFoundException;
import edu.ac.gitdebugging.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public Person findOne(Long id) {
		Person person = personRepository.findOne(id);
		if( person == null )
			throw new PersonNotFoundException();
		return person;
	}
	
	public Iterable<Person> findAll(){
		return personRepository.findAll();
	}
	
	public Person update(Person person){
		if( findOne(person.getId()) == null )
			throw new PersonNotFoundException();
		
		return personRepository.save(person);
	}
	
	public Person insert(Person person){
		return personRepository.save(person);
	}
	
	public long count(){
		return personRepository.count();
	}
	
	public void delete(Long id){
		if( findOne( id ) == null )
			throw new PersonNotFoundException();
		personRepository.delete(id);
	}
	
}
