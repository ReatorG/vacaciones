package com.example.vacaciones.AppUser.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class AppUserDTO {
    private String username;
    private String password;
    private String email;

}
