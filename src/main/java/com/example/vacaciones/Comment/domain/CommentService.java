package com.example.vacaciones.Comment.domain;

import com.example.vacaciones.AppUser.domain.Role;
import com.example.vacaciones.Comment.infrastructure.CommentRepository;
import com.example.vacaciones.Writing.domain.Writing;
import com.example.vacaciones.Writing.infrastructure.WritingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private WritingRepository writingRepository;

    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    public Comment createComment(Long writingId, Comment comment) {
        Writing writing = writingRepository.
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public void updateComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("AppUser not found"));
        commentRepository.save(comment);
    }

    public List<Comment> getCommentsByExtract(String text) {
        return commentRepository.findByText(text);
    }

}
