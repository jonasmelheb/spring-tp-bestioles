package fr.diginamic.springWeb.repository;

import fr.diginamic.springWeb.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Long> {
}
