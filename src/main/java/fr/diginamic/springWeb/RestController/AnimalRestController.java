package fr.diginamic.springWeb.RestController;

import fr.diginamic.springWeb.domain.Animal;
import fr.diginamic.springWeb.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class AnimalRestController {
    @Autowired
    private AnimalService animalService;

    @GetMapping("")
    public List<Animal> listSpecie() {
        return animalService.list();
    }

    @PostMapping("")
    public Long createSpecie(@RequestBody Animal animal) {
        animalService.create(animal);
        return animal.getId();
    }

    @PutMapping("/{id}")
    public Animal updateSpecie(@PathVariable("id") Long id, @RequestBody Animal animal) {
        if (animalService.get(id) != null) {
            animalService.update(animal);
            return animal;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Long deleteSpecie(@PathVariable("id") Long id) {
        if (animalService.get(id) != null) {
            animalService.delete(id);
            return id;
        }
        return null;
    }
}
