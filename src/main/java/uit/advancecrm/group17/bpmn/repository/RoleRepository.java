package uit.advancecrm.group17.bpmn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uit.advancecrm.group17.bpmn.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
