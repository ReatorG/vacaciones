package com.example.vacaciones.Comment.domain;

import com.example.vacaciones.AppUser.domain.AppUser;
import com.example.vacaciones.AppUser.domain.Role;
import com.example.vacaciones.AppUser.infrastructure.AppUserRepository;
import com.example.vacaciones.Comment.dto.CommentDTO;
import com.example.vacaciones.Comment.infrastructure.CommentRepository;
import com.example.vacaciones.Writing.domain.Writing;
import com.example.vacaciones.Writing.infrastructure.WritingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private WritingRepository writingRepository;

    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    public Comment createComment(CommentDTO commentDTO) {
        AppUser appUser = appUserRepository.findById(commentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Writing writing = writingRepository.findById(commentDTO.getWritingId())
                .orElseThrow(() -> new RuntimeException("Writing not found"));

        Comment comment = new Comment();
        comment.setText(commentDTO.getText());
        comment.setAppUser(appUser);
        comment.setWriting(writing);
        comment.setRating(commentDTO.getRating() != null ? commentDTO.getRating() : 0); // Default to 0 if not provided

        return commentRepository.save(comment);
    }


    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public void updateComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        commentRepository.save(comment);
    }

    public List<Comment> getCommentsByExtract(String text) {
        return commentRepository.findByText(text);
    }

    public List<Comment> getCommentsByRating(int limit){
        Pageable pageable = PageRequest.of(0, limit);
        return commentRepository.findTopRatedComments(pageable);
    }

}
