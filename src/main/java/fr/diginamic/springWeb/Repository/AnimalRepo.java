package fr.diginamic.springWeb.Repository;

import fr.diginamic.springWeb.Domain.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepo extends CrudRepository<Animal, Long> {
}
