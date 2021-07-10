package fr.diginamic.springWeb.Controllers;

import fr.diginamic.springWeb.domain.Animal;
import fr.diginamic.springWeb.domain.Specie;
import fr.diginamic.springWeb.service.AnimalService;
import fr.diginamic.springWeb.service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @Autowired
    private SpecieService specieService;

    @GetMapping("/animal")
    public String listAnimal(Model model) {
        List<Animal> animals = animalService.list();
        model.addAttribute("Animals", animals);
        return "list_animal";
    }

    @GetMapping("/animal/create/{id}")
    public String createAnimal(@PathVariable("id") long id, Model model) {
        Animal animal = null;
        List<Specie> species = specieService.list();
        if (id == 0L) {
            animal = new Animal(0L, "", "", "", null);
        } else {
            animal = animalService.get(id);
        }
        model.addAttribute("animal", animal);
        model.addAttribute("species", species);
        return "create_animal";
    }

    @PostMapping("/animal/create")
    public String postCreate(Animal animal) {
        if (animal.getId() == 0L) {
            animalService.create(animal);
        } else {
            animalService.update(animal);
        }
        return "redirect:/animal";
    }

    @GetMapping("/animal/delete/{id}")
    public String deleteAnimal(@PathVariable("id") long id) {
        animalService.delete(id);
        return "redirect:/animal";
    }
}
