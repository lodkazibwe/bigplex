package com.bigplex.bigplex.movie.service;

import com.bigplex.bigplex.movie.dto.EpisodeDto;
import com.bigplex.bigplex.movie.dto.MovieDto;
import com.bigplex.bigplex.movie.model.Episode;
import com.bigplex.bigplex.movie.model.Movie;

import java.util.List;

public interface MovieService {
    Movie addMovie(MovieDto movieDto);
    Movie getMovie(int movieId);
    Movie getMovie(String title);
    boolean movieExists(String title);
    List<Movie> getAll();
    List<Movie> getAll(String category);

    Movie addEpisode(int movieId, EpisodeDto episodeDto);
    Movie deleteEpisode(int movieId, int episodeId);

}
