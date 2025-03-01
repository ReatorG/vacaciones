package com.example.vacaciones.Writing.application;

import com.example.vacaciones.Writing.domain.Writing;
import com.example.vacaciones.Writing.domain.WritingService;
import com.example.vacaciones.Writing.dto.WritingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/writing")
public class WritingController {

    @Autowired
    private WritingService writingService;

    @GetMapping("/{id}")
    public ResponseEntity<Writing> getWriting(@PathVariable Long id) {
        return ResponseEntity.ok(writingService.getWriting(id));
    }

    @PostMapping
    public ResponseEntity<Writing> createWriting(@RequestBody WritingDTO writingRequestDto) {
        Writing savedWriting = writingService.createWriting(writingRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWriting);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Writing>> getAllWritings() {
        return ResponseEntity.ok(writingService.getAllWritings());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateWriting(@PathVariable Long id, @RequestBody Writing appUser) {
        writingService.updateWriting(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppUser(@PathVariable Long id) {
        writingService.deleteWriting(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<Writing>> getWritingsByTitle(@PathVariable String title) {
        return ResponseEntity.ok(writingService.getWritingsByTitle(title));
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<List<Writing>> getWritingsByAuthorId(@PathVariable Long authorId) {
        return ResponseEntity.ok(writingService.getWritingsByAuthor(authorId));
    }

    @GetMapping("/rating")
    public ResponseEntity<List<Writing>> getWritingsByRating() {
        return ResponseEntity.ok(writingService.getTopRatedWritings(20));
    }

}
