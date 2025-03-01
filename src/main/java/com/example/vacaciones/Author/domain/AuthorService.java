package com.example.vacaciones.Author.domain;

import com.example.vacaciones.Author.infrastructure.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author getAuthor(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public void updateAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        authorRepository.save(author);
    }

    public List<Author> getAuthorsByName(String name) {
        return authorRepository.findByAppUser_Username(name);
    }

    public List<Author> getTopRatedAuthors(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return authorRepository.findTopRatedAuthors(pageable);
    }

}
