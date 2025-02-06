package com.example.vacaciones.Comment.domain;

import com.example.vacaciones.AppUser.domain.AppUser;
import com.example.vacaciones.Writing.domain.Writing;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Data
@Setter
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    @Column(nullable = false)
    private int rating;

    @ManyToOne
    private Writing writing;
}
