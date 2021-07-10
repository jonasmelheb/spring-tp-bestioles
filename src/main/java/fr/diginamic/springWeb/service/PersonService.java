package fr.diginamic.springWeb.service;

import fr.diginamic.springWeb.domain.Person;
import fr.diginamic.springWeb.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepo repo;

    public List<Person> list() {
        return (List<Person>) repo.findAll();
    }

    public Long create(Person person) {
        person.setId(null);
        person = repo.save(person);
        return person.getId();
    }

    public void update(Person person) {
        person = repo.save(person);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public void delete(Person person) {
        repo.delete(person);
    }

    public Person get(Long id) {
        Optional<Person> opt = repo.findById(id);
        if (!opt.isPresent()) {
            return null;
        }
        return opt.get();
    }
}
