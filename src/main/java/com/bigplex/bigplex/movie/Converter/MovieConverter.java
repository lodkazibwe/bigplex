package com.bigplex.bigplex.movie.Converter;

import com.bigplex.bigplex.movie.dto.MovieDto;
import com.bigplex.bigplex.movie.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieConverter {
    @Autowired EpisodeConverter episodeConverter;

    public MovieDto entityToDto(Movie movie){
        MovieDto movieDto =new MovieDto();
        movieDto.setMovieId(movie.getMovieId());
        movieDto.setCategory(movie.getCategory());
        movieDto.setCover(movie.getCover());
        movieDto.setSubCat(movie.getSubCat());
        movieDto.setSummary(movie.getSummary());
        movieDto.setTitle(movie.getTitle());
        movieDto.setEpisodes(episodeConverter.entityToDto(movie.getEpisodes()));
        return movieDto;
    }

    public Movie dtoToEntity(MovieDto movieDto){
        Movie movie =new Movie();
        movie.setEpisodes(episodeConverter.dtoToEntity(movieDto.getEpisodes()));
        movie.setCover(movieDto.getCover());
        movie.setCategory(movieDto.getCategory());
        movie.setSubCat(movieDto.getSubCat());
        movie.setSummary(movieDto.getSummary());
        movie.setTitle(movieDto.getTitle());
        return movie;
    }

    public List<MovieDto> entityToDto(List<Movie> movieList){
        return movieList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<Movie> dtoToEntity(List<MovieDto> movieDtoList){
        return  movieDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
