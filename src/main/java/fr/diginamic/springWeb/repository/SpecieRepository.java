package fr.diginamic.springWeb.repository;

import fr.diginamic.springWeb.domain.Specie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpecieRepository extends CrudRepository<Specie, Long> {
	Optional<Specie> findByCommonName(String name);
}
