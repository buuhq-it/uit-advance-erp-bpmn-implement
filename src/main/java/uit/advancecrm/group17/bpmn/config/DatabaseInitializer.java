package uit.advancecrm.group17.bpmn.config;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uit.advancecrm.group17.bpmn.entity.Role;
import uit.advancecrm.group17.bpmn.entity.User;
import uit.advancecrm.group17.bpmn.repository.RoleRepository;
import uit.advancecrm.group17.bpmn.repository.UserRepository;

import java.util.Set;

@Service
public class DatabaseInitializer {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public DatabaseInitializer(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        // Check and create roles if they don't exist
        Role userRole = roleRepository.findByName("USER")
                .orElseGet(() -> {
                    Role newRole = Role.builder().name("USER").build();
                    return roleRepository.save(newRole);
                });
        Role adminRole = roleRepository.findByName("ADMIN")
                .orElseGet(() -> {
                    Role newRole = Role.builder().name("ADMIN").build();
                    return roleRepository.save(newRole);
                });
        Role guestRole = roleRepository.findByName("GUEST")
                .orElseGet(() -> {
                    Role newRole = Role.builder().name("GUEST").build();
                    return roleRepository.save(newRole);
                });

        // Check and create users if they don't exist
        if (userRepository.findByUsername("user").isEmpty()) {
            User user = User.builder()
                    .username("user")
                    .password(passwordEncoder.encode("password"))
                    .roles(Set.of(userRole))
                    .build();
            userRepository.save(user);
        }

        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("password"))
                    .roles(Set.of(userRole, adminRole))
                    .build();
            userRepository.save(admin);
        }

        if (userRepository.findByUsername("specialuser").isEmpty()) {
            User specialUser = User.builder()
                    .username("specialuser")
                    .password(passwordEncoder.encode("password"))
                    .roles(Set.of(userRole))
                    .build();
            userRepository.save(specialUser);
        }

        if (userRepository.findByUsername("guest").isEmpty()) {
            User guest = User.builder()
                    .username("guest")
                    .password(passwordEncoder.encode("password"))
                    .roles(Set.of(guestRole))
                    .build();
            userRepository.save(guest);
        }
    }
}
