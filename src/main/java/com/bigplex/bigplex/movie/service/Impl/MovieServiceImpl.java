package com.bigplex.bigplex.movie.service.Impl;

import com.bigplex.bigplex.exceptions.InvalidValuesException;
import com.bigplex.bigplex.exceptions.ResourceNotFoundException;
import com.bigplex.bigplex.movie.Converter.EpisodeConverter;
import com.bigplex.bigplex.movie.Converter.MovieConverter;
import com.bigplex.bigplex.movie.dao.EpisodeDao;
import com.bigplex.bigplex.movie.dao.MovieDao;
import com.bigplex.bigplex.movie.dto.EpisodeDto;
import com.bigplex.bigplex.movie.dto.MovieDto;
import com.bigplex.bigplex.movie.model.Episode;
import com.bigplex.bigplex.movie.model.Movie;
import com.bigplex.bigplex.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired MovieConverter movieConverter;
    @Autowired EpisodeConverter episodeConverter;
    @Autowired MovieDao movieDao;
    @Autowired EpisodeDao episodeDao;

    @Override
    public Movie addMovie(MovieDto movieDto) {
        boolean bool =movieExists(movieDto.getTitle());
        if(bool){
            throw new InvalidValuesException("movie already exists");
        }
        return movieDao.save(movieConverter.dtoToEntity(movieDto));
    }

    @Override
    public Movie getMovie(int movieId) {
        return movieDao.findById(movieId)
                .orElseThrow(()->new ResourceNotFoundException("no such movie "+movieId));
    }
    public Episode getEpisode(int episodeId) {
        return episodeDao.findById(episodeId)
                .orElseThrow(()->new ResourceNotFoundException("no such movie "+episodeId));
    }

    @Override
    public Movie getMovie(String title) {
        return movieDao.findByTitle(title);
    }

    @Override
    public boolean movieExists(String title) {
        return movieDao.existsByTitle(title);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.findAll();
    }

    @Override
    public List<Movie> getAll(String category) {
        return movieDao.findByCategory(category);
    }

    @Override
    public Movie addEpisode(int movieId, EpisodeDto episodeDto) {
        Movie movie =getMovie(movieId);
        movie.getEpisodes().add(episodeConverter.dtoToEntity(episodeDto));
        return movieDao.save(movie);
    }

    @Override
    public Movie deleteEpisode(int movieId, int episodeId) {
        Episode episode =getEpisode(episodeId);
        Movie movie =getMovie(movieId);
        movie.getEpisodes().remove(episode);
        return movieDao.save(movie);
    }


}
