package com.github.ztmma31.cpm.app.repository;

import java.util.Optional;

import com.github.ztmma31.cpm.app.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
