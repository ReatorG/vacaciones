package com.example.vacaciones.Author.domain;

import com.example.vacaciones.AppUser.domain.AppUser;
import com.example.vacaciones.Writing.domain.Writing;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "author")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "authorId")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId; // This is the separate author ID

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private AppUser appUser; // Link to AppUser

    @Column(nullable = false)
    private float rating;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Writing> writings = new ArrayList<>();

    @Transient
    private List<List<Writing>> collections;
}
