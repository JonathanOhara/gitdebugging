package edu.ac.gitdebugging.repository;

import org.springframework.data.repository.CrudRepository;

import edu.ac.gitdebugging.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
