package com.example.vacaciones.Comment.application;

import com.example.vacaciones.Comment.domain.Comment;
import com.example.vacaciones.Comment.domain.CommentService;
import com.example.vacaciones.Comment.dto.CommentDTO;
import com.example.vacaciones.Writing.domain.Writing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.getComment(id));
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CommentDTO commentDTO) {
        Comment savedWriting = commentService.createComment(commentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWriting);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Comment>> getAllComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateComment(@PathVariable Long id, @RequestBody Writing appUser) {
        commentService.updateComment(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{extract}")
    public ResponseEntity<List<Comment>> getCommentsByExtract(@PathVariable String extract) {
        return ResponseEntity.ok(commentService.getCommentsByExtract(extract));
    }

    @GetMapping("/rating")
    public ResponseEntity<List<Comment>> getCommentsByRating() {
        return ResponseEntity.ok(commentService.getCommentsByRating(20));
    }

}