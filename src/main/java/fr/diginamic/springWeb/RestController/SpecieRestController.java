package fr.diginamic.springWeb.RestController;

import fr.diginamic.springWeb.domain.Specie;
import fr.diginamic.springWeb.service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specie")
public class SpecieRestController {
    @Autowired
    private SpecieService specieService;

    @GetMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Specie> listSpecie() {
        return specieService.list();
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public Long createSpecie(@RequestBody Specie specie) {
        specieService.create(specie);
        return specie.getId();
    }

    @PutMapping("/{id}")
    public Specie updateSpecie(@PathVariable("id") Long id, @RequestBody Specie specie) {
        if (specieService.get(id) != null) {
            specieService.update(specie);
            return specie;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Long deleteSpecie(@PathVariable("id") Long id) {
        if (specieService.get(id) != null) {
            specieService.delete(id);
            return id;
        }
        return null;
    }
}
