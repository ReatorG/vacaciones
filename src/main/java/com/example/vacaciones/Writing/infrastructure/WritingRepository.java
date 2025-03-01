package com.example.vacaciones.Writing.infrastructure;

import com.example.vacaciones.Author.domain.Author;
import com.example.vacaciones.Writing.domain.Writing;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WritingRepository extends JpaRepository<Writing, Long> {
    List<Writing> findByTitle(String title);

    List<Writing> findByAuthor_AuthorId(Long authorId);

    @Query("SELECT w FROM Writing w JOIN w.author a ORDER BY a.rating DESC")
    List<Writing> findTopRatedWritings(Pageable pageable);
}
