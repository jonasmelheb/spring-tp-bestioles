package fr.diginamic.springWeb.Service;

import fr.diginamic.springWeb.Domain.Animal;
import fr.diginamic.springWeb.Repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    AnimalRepo repo;

    public List<Animal> list() {
        return (List<Animal>) repo.findAll();
    }

    public Long create(Animal animal) {
        animal.setId(null);
        animal = repo.save(animal);
        return animal.getId();
    }

    public void update(Animal animal) {
        animal = repo.save(animal);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public void delete(Animal animal) {
        repo.delete(animal);
    }

    public Animal get(Long id) {
        Optional<Animal> opt = repo.findById(id);
        if (!opt.isPresent()) {
            return null;
        }
        return opt.get();
    }
}
