package com.example.vacaciones.Author.infrastructure;

import com.example.vacaciones.Author.domain.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByUsername(String name);

    @Query("SELECT a FROM Author a ORDER BY a.rating DESC")
    List<Author> findTopRatedAuthors(Pageable pageable);

}
