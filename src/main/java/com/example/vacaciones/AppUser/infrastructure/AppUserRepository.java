package com.example.vacaciones.AppUser.infrastructure;

import com.example.vacaciones.AppUser.domain.AppUser;
import com.example.vacaciones.Author.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    List<AppUser> findByUsername(String name);

}
