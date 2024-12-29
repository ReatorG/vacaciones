package com.example.vacaciones.Author.domain;

import com.example.vacaciones.Writing.domain.Writing;
import com.example.vacaciones.user.domain.User;
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
public class Author extends User {

    @Column(nullable = false)
    private float rating;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Writing> writings = new ArrayList<>();

    @Transient
    private List<List<Writing>> collections;
}
