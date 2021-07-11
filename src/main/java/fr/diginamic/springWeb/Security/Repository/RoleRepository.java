package fr.diginamic.springWeb.Security.Repository;

import fr.diginamic.springWeb.Security.AuthModels.ERole;
import fr.diginamic.springWeb.Security.AuthModels.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
