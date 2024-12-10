package com.example.vacaciones;

import org.springframework.boot.SpringApplication;

public class TestVacacionesApplication {

    public static void main(String[] args) {
        SpringApplication.from(VacacionesApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
