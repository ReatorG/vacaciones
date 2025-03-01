package com.example.vacaciones.Comment.infrastructure;

import com.example.vacaciones.Author.domain.Author;
import com.example.vacaciones.Comment.domain.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findByText(String text);

    @Query("SELECT a FROM Comment a ORDER BY a.rating DESC")
    List<Comment> findTopRatedComments(Pageable pageable);
}
