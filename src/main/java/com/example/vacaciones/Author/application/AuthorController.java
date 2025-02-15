package com.example.vacaciones.Author.application;

import com.example.vacaciones.Author.domain.Author;
import com.example.vacaciones.Author.domain.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthor(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        authorService.updateAuthor(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Author>> getAuthorByName(@PathVariable String name) {
        return ResponseEntity.ok(authorService.getAuthorsByName(name));
    }

    @GetMapping("/rating")
    public ResponseEntity<List<Author>> getTopRatedAuthors(@RequestParam(defaultValue = "20") int limit) {
        List<Author> authors = authorService.getTopRatedAuthors(limit);
        return ResponseEntity.ok(authors);
    }
}
