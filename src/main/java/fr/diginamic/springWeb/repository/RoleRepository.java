package fr.diginamic.springWeb.repository;

import fr.diginamic.springWeb.security.AuthModels.ERole;
import fr.diginamic.springWeb.security.AuthModels.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
