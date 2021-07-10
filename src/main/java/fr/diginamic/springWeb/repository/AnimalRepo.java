package fr.diginamic.springWeb.repository;

import fr.diginamic.springWeb.domain.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepo extends CrudRepository<Animal, Long> {
}
