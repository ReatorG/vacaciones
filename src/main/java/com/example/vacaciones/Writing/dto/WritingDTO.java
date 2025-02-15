package com.example.vacaciones.Writing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class WritingDTO {
    private String title;
    private String content;
    private Long authorId;

}
