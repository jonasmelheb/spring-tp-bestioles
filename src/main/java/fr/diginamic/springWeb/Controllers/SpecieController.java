package fr.diginamic.springWeb.Controllers;

import fr.diginamic.springWeb.Domain.Specie;
import fr.diginamic.springWeb.Service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SpecieController {

    @Autowired
    private SpecieService specieService;

    @GetMapping("/specie")
    public String listSpecie(Model model) {
        List<Specie> species = specieService.list();
        model.addAttribute("Species", species);
        return "list_specie";
    }

    @GetMapping("/specie/create/{id}")
    public String createSpecie(@PathVariable("id") long id, Model model) {
        Specie specie = null;
        if (id == 0L) {
            specie = new Specie(0L, "", "");
        } else {
            specie = specieService.get(id);
        }
        model.addAttribute("specie", specie);
        return "create_specie";
    }

    @PostMapping("/specie/create")
    public String postCreate(Specie specie) {
        if (specie.getId() == 0L) {
            specieService.create(specie);
        } else {
            specieService.update(specie);
        }
        return "redirect:/specie";
    }

    @GetMapping("/specie/delete/{id}")
    public String deleteSpecie(@PathVariable("id") long id) {
        specieService.delete(id);
        return "redirect:/specie";
    }
}
