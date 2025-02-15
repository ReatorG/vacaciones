package com.example.vacaciones.AppUser.application;

import com.example.vacaciones.AppUser.domain.AppUser;
import com.example.vacaciones.AppUser.domain.AppUserService;
import com.example.vacaciones.AppUser.dto.AppUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getAppUser(@PathVariable Long id) {
        return ResponseEntity.ok(appUserService.getAppUser(id));
    }

    @PostMapping
    public ResponseEntity<AppUser> createAppUser(@RequestBody AppUserDTO userRequestDto) {
        AppUser savedAppUser = appUserService.createAppUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppUser);
    }

    @GetMapping("/list")
    public ResponseEntity<List<AppUser>> getAllAppUsers() {
        return ResponseEntity.ok(appUserService.getAllAppUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAppUser(@PathVariable Long id, @RequestBody AppUser appUser) {
        appUserService.updateAppUser(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppUser(@PathVariable Long id) {
        appUserService.deleteAppUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<AppUser>> getAppUsersByName(@PathVariable String name) {
        return ResponseEntity.ok(appUserService.getAppUsersByName(name));
    }

}
