package com.bigplex.bigplex.movie.rest.v1;

import com.bigplex.bigplex.movie.Converter.MovieConverter;
import com.bigplex.bigplex.movie.dto.EpisodeDto;
import com.bigplex.bigplex.movie.dto.MovieDto;
import com.bigplex.bigplex.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired MovieConverter movieConverter;
    @Autowired MovieService movieService;

    @PostMapping("/addNew")
    public ResponseEntity<MovieDto> addMovie(@Valid @RequestBody MovieDto movieDto){
        return new ResponseEntity<>(movieConverter.entityToDto(movieService.addMovie(movieDto)), HttpStatus.OK);

    }
    @GetMapping("/getById/{movieId}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable int movieId){
        return new ResponseEntity<>(movieConverter.entityToDto(movieService.getMovie(movieId)), HttpStatus.OK);

    }
    @GetMapping("/getByTitle/{title}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable String title){
        return new ResponseEntity<>(movieConverter.entityToDto(movieService.getMovie(title)), HttpStatus.OK);

    }
    @GetMapping("/getAll")
    public ResponseEntity<List<MovieDto>> getAll(){
        return new ResponseEntity<>(movieConverter.entityToDto(movieService.getAll()), HttpStatus.OK);

    }
    @GetMapping("/getByCat/{category}")
    public ResponseEntity<List<MovieDto>> getAll(@PathVariable String category){
        return new ResponseEntity<>(movieConverter.entityToDto(movieService.getAll(category)), HttpStatus.OK);

    }

    @PutMapping("/addEpisode/{movieId}")
    public ResponseEntity<MovieDto> addEpisode(@PathVariable int movieId, @Valid @RequestBody EpisodeDto episodeDto){
        return new ResponseEntity<>(movieConverter.entityToDto(movieService.addEpisode(movieId, episodeDto)), HttpStatus.OK);

    }
    @PutMapping("/removeEpisode/{movieId}/{episodeId}")
    public ResponseEntity<MovieDto> deleteEpisode(@PathVariable int movieId, @PathVariable int episodeId){
        return new ResponseEntity<>(movieConverter.entityToDto(movieService.deleteEpisode(movieId, episodeId)), HttpStatus.OK);

    }
}
