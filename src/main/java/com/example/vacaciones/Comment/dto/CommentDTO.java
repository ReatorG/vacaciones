package com.example.vacaciones.Comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class CommentDTO {
    private String text;
    private Long writingId;
    private Long userId;
    private Float rating;

}
