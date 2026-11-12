package com.github.ztmma31.cpm.app;

import com.github.ztmma31.cpm.app.model.AppUser;
import com.github.ztmma31.cpm.app.model.Role;
import com.github.ztmma31.cpm.app.repository.UserRepository;
import com.github.ztmma31.cpm.app.security.AppUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppUserDetailsServiceTest {

    private final UserRepository repo = mock(UserRepository.class);
    private final AppUserDetailsService service = new AppUserDetailsService(repo);

    @Test
    void knownUserIsLoadedWithRole() {
        when(repo.findByEmail("maxbui@cmail.carleton.ca"))
            .thenReturn(Optional.of(new AppUser("Max", "maxbui@cmail.carleton.ca", "BankStreet123", Role.STUDENT, "Software")));

        UserDetails d = service.loadUserByUsername("maxbui@cmail.carleton.ca");

        assertThat(d.getUsername()).isEqualTo("maxbui@cmail.carleton.ca");
        assertThat(d.getAuthorities().iterator().next().getAuthority()).isEqualTo("ROLE_STUDENT");
    }

    @Test
    void unknownUserIsRejected() {
        when(repo.findByEmail("ratthewmoss@cmail.carleton.ca")).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> service.loadUserByUsername("ratthewmoss@cmail.carleton.ca"));
    }
}
