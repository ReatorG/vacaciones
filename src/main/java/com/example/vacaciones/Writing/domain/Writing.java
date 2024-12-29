package com.example.vacaciones.Writing.domain;

import com.example.vacaciones.Author.domain.Author;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Writing {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Date publishDate;

    @ManyToOne
    private Author author;

}
