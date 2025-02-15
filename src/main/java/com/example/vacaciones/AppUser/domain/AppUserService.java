package com.example.vacaciones.AppUser.domain;

import com.example.vacaciones.AppUser.dto.AppUserDTO;
import com.example.vacaciones.AppUser.infrastructure.AppUserRepository;
import com.example.vacaciones.Author.infrastructure.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser getAppUser(Long id) {
        return appUserRepository.findById(id).orElseThrow(() -> new RuntimeException("AppUser not found"));
    }

    public AppUser createAppUser(AppUserDTO appUserDTO) {
        AppUser appUser = new AppUser();
        appUser.setUsername(appUserDTO.getUsername());
        appUser.setPassword(appUserDTO.getPassword());
        appUser.setEmail(appUserDTO.getEmail());
        appUser.setRole(Role.READER);

        return appUserRepository.save(appUser);
    }

    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }

    public void deleteAppUser(Long id) {
        appUserRepository.deleteById(id);
    }

    public void updateAppUser(Long id) {
        AppUser appUser = appUserRepository.findById(id).orElseThrow(() -> new RuntimeException("AppUser not found"));
        appUserRepository.save(appUser);
    }

    public List<AppUser> getAppUsersByName(String name) {
        return appUserRepository.findByUsername(name);
    }

}
