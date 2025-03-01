package com.example.vacaciones.Writing.domain;

import com.example.vacaciones.Author.domain.Author;
import com.example.vacaciones.Comment.domain.Comment;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Data
@Setter
@NoArgsConstructor
@Entity
public class Writing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private long likes;

    @Column(nullable = false)
    private long views;

    @Column(nullable = false)
    private float rating;

    @Column(nullable = false)
    private Date publishDate;

    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "writing", fetch = FetchType.LAZY)
    private List<Comment> comments;
}
