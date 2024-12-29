package com.example.vacaciones.Writing.domain;

import com.example.vacaciones.Author.domain.Author;
import jakarta.persistence.ManyToOne;

public class Writing {

    @ManyToOne
    private Author author;

}
