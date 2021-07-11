package fr.diginamic.springWeb.Controllers;

import fr.diginamic.springWeb.Domain.Animal;
import fr.diginamic.springWeb.Domain.Person;
import fr.diginamic.springWeb.Service.AnimalService;
import fr.diginamic.springWeb.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @Autowired
    private AnimalService animalService;

    @GetMapping("/person")
    public String listPerson(Model model) {
        List<Person> persons = personService.list();
        model.addAttribute("Persons", persons);
        return "list_person";
    }

    @GetMapping("/person/create/{id}")
    public String createPerson(@PathVariable("id") long id, Model model) {
        Person person = null;
        List<Animal> animals = animalService.list();
        if (id == 0L) {
            person = new Person(0L, "", "", 0, null);
        } else {
            person = personService.get(id);
        }
        model.addAttribute("person", person);
        model.addAttribute("animals", animals);
        return "create_person";
    }

    @PostMapping("/person/create")
    public String postCreate(Person person) {
        if (person.getId() == 0L) {
            personService.create(person);
        } else {
            personService.update(person);
        }
        return "redirect:/person";
    }

    @GetMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable("id") long id) {
        personService.delete(id);
        return "redirect:/person";
    }
}
