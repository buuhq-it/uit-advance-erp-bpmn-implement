/*
package uit.advancecrm.group17.bpmn.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uit.advancecrm.group17.bpmn.entity.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {
    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convert user roles into GrantedAuthorities (for role-based authorization)
        return user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Change according to your needs
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Change according to your needs
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Change according to your needs
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled(); // Check if the user is enabled
    }
}
*/