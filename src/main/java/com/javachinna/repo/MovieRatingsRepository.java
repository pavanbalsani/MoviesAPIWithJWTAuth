package com.javapavan.repo;

import com.javapavan.model.MovieRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JPA Repository for MovieRatings entity
 *
 * @author Pavan
 */
@Repository
public interface MovieRatingsRepository extends JpaRepository<MovieRating, Long> {
    Optional<MovieRating> findByMovieTitleAndUserEmail(String title, String username);
}
