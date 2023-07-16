package com.javapavan.service;

import com.javapavan.dto.MovieDTO;
import com.javapavan.model.Movie;

/**
 * Service interface that provides OMDB API connection
 *
 * @author Pavan
 */
public interface OMDBService {
    /**
     * Fetches the box office value by movie title from OMDB API
     *
     * @param movie The {@link Movie}
     * @return MovieDTO
     */
    MovieDTO enrichMovieWithBoxOfficeValue(Movie movie);
}
