package fr.diginamic.springWeb.service;

import fr.diginamic.springWeb.domain.Specie;
import fr.diginamic.springWeb.repository.SpecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class SpecieService {
    @Autowired
    SpecieRepository repo;

    public List<Specie> list() {
        return (List<Specie>) repo.findAll();
    }

    public Long create(Specie sp) {
        sp.setId(null);
        sp = repo.save(sp);
        return sp.getId();
    }

    public void update(Specie sp) {
        sp = repo.save(sp);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public void delete(Specie sp) {
        repo.delete(sp);
    }

    public Specie get(Long id) {
        Optional<Specie> opt = repo.findById(id);
        if (!opt.isPresent()) {
            return null;
        }
        return opt.get();
    }

    public Specie getByCommonName(String commonName) {
        Optional<Specie> opt = repo.findByCommonName(commonName);
        if (!opt.isPresent()) {
            return null;
        }
        return opt.get();
    }

}
