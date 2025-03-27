package uit.advancecrm.group17.bpmn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uit.advancecrm.group17.bpmn.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
