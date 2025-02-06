package com.example.vacaciones.Author.domain;

import com.example.vacaciones.AppUser.domain.AppUser;
import com.example.vacaciones.Writing.domain.Writing;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Author extends AppUser {

    @Column(nullable = false)
    private float rating;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Writing> writings = new ArrayList<>();

    @Transient
    private List<List<Writing>> collections;
}
