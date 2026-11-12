package com.github.ztmma31.cpm.app.config;

import com.github.ztmma31.cpm.app.model.AppUser;
import com.github.ztmma31.cpm.app.model.Role;
import com.github.ztmma31.cpm.app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedUsers(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.count() > 0) return;
            String hash = encoder.encode("password");
            repo.save(new AppUser("Max Bui", "maxbui@cmail.carleton.ca", hash, Role.STUDENT, "Software"));
            repo.save(new AppUser("Edward Kurita", "edwardkurita@cmail.carleton.ca", hash, Role.STUDENT, "Software"));
            repo.save(new AppUser("Matthew Ross", "matthew.ross4@cmail.carleton.ca", hash, Role.STUDENT, "Software"));
            repo.save(new AppUser("Zane Labonte-Hagar", "zanelabontehagar@cmail.carleton.ca", hash, Role.STUDENT, "Software"));
            repo.save(new AppUser("Amber Skinner", "amberskinner@cmail.carleton.ca", hash, Role.STUDENT, "Software"));
            repo.save(new AppUser("Babak Esfandiari", "babakesfandiari@cunet.carleton.ca", hash, Role.PROF, null));
        };
    }
}
