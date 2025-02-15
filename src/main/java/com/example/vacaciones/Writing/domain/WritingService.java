package com.example.vacaciones.Writing.domain;

import com.example.vacaciones.Author.domain.Author;
import com.example.vacaciones.Author.infrastructure.AuthorRepository;
import com.example.vacaciones.Writing.domain.Writing;
import com.example.vacaciones.Writing.dto.WritingDTO;
import com.example.vacaciones.Writing.infrastructure.WritingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WritingService {

    @Autowired
    private WritingRepository writingRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Writing getWriting(Long id) {
        return writingRepository.findById(id).orElseThrow(() -> new RuntimeException("Writing not found"));
    }

    public Writing createWriting(WritingDTO writingDTO) {
        Author author = authorRepository.findById(writingDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Writing writing = new Writing();
        writing.setTitle(writingDTO.getTitle());
        writing.setContent(writingDTO.getContent());
        writing.setAuthor(author);

        return writingRepository.save(writing);
    }

    public List<Writing> getAllWritings() {
        return writingRepository.findAll();
    }

    public void deleteWriting(Long id) {
        writingRepository.deleteById(id);
    }

    public void updateWriting(Long id) {
        Writing author = writingRepository.findById(id).orElseThrow(() -> new RuntimeException("Writing not found"));
        writingRepository.save(author);
    }

    public List<Writing> getWritingsByTitle(String title) {
        return writingRepository.findByTitle(title);
    }

    public List<Writing> getWritingsByAuthor(Long authorId) {
        return writingRepository.findByAuthorId(authorId);
    }

    public List<Writing> getTopRatedWritings(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return writingRepository.findTopRatedWritings(pageable);
    }

}
