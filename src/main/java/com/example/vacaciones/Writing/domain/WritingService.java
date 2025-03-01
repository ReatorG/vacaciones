package com.example.vacaciones.Writing.domain;

import com.example.vacaciones.AppUser.domain.AppUser;
import com.example.vacaciones.AppUser.domain.Role;
import com.example.vacaciones.AppUser.infrastructure.AppUserRepository;
import com.example.vacaciones.Author.domain.Author;
import com.example.vacaciones.Author.infrastructure.AuthorRepository;
import com.example.vacaciones.Writing.domain.Writing;
import com.example.vacaciones.Writing.dto.WritingDTO;
import com.example.vacaciones.Writing.infrastructure.WritingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WritingService {

    @Autowired
    private WritingRepository writingRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    public Writing getWriting(Long id) {
        return writingRepository.findById(id).orElseThrow(() -> new RuntimeException("Writing not found"));
    }

    @Transactional
    public Writing createWriting(WritingDTO writingRequestDto) {
        AppUser user = appUserRepository.findById(writingRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Writing writing = new Writing();
        writing.setTitle(writingRequestDto.getTitle());
        writing.setContent(writingRequestDto.getContent());
        writing.setLikes(0); // Default value
        writing.setViews(0); // Default value
        writing.setRating(0); // Default rating
        writing.setPublishDate(new Date()); // Set current date

        Optional<Author> existingAuthor = authorRepository.findByAppUserId(user.getId());
        Author author = existingAuthor.orElseGet(() -> {
            Author newAuthor = new Author();
            newAuthor.setAppUser(user);
            newAuthor.setRating(0.0f);
            return authorRepository.save(newAuthor);
        });

        writing.setAuthor(author);
        return writingRepository.save(writing);
    }


    public List<Writing> getAllWritings() {
        return writingRepository.findAll();
    }

    public void deleteWriting(Long id) {
        writingRepository.deleteById(id);
    }

    public void updateWriting(Long id) {
        Writing author = writingRepository.findById(id).orElseThrow(() -> new RuntimeException("Writing not found"));
        writingRepository.save(author);
    }

    public List<Writing> getWritingsByTitle(String title) {
        return writingRepository.findByTitle(title);
    }

    public List<Writing> getWritingsByAuthor(Long authorId) {
        return writingRepository.findByAuthor_AuthorId(authorId);
    }

    public List<Writing> getTopRatedWritings(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return writingRepository.findTopRatedWritings(pageable);
    }

}
