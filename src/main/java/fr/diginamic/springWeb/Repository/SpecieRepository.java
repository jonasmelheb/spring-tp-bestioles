package fr.diginamic.springWeb.Repository;

import fr.diginamic.springWeb.Domain.Specie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpecieRepository extends CrudRepository<Specie, Long> {
	Optional<Specie> findByCommonName(String name);
}
