package com.example.vacaciones.Writing.infrastructure;

import com.example.vacaciones.Author.domain.Author;
import com.example.vacaciones.Writing.domain.Writing;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WritingRepository extends JpaRepository<Writing, Long> {
    public List<Writing> findByTitle(String title);
    public List<Writing> findByAuthorId(Long id);

    @Query("SELECT a FROM Writing a ORDER BY a.rating DESC")
    List<Writing> findTopRatedWritings(Pageable pageable);
}