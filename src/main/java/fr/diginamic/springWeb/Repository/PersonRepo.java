package fr.diginamic.springWeb.Repository;

import fr.diginamic.springWeb.Domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Long> {
}
