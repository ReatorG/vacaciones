package com.example.vacaciones.AppUser.infrastructure;

import com.example.vacaciones.AppUser.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

}
