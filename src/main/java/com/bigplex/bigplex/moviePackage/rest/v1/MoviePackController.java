package com.bigplex.bigplex.moviePackage.rest.v1;

import com.bigplex.bigplex.moviePackage.Converter.PackConverter;
import com.bigplex.bigplex.moviePackage.dto.MoviePackDto;
import com.bigplex.bigplex.moviePackage.service.MoviePackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pack")
public class MoviePackController {
    @Autowired MoviePackService moviePackService;
    @Autowired PackConverter packConverter;

    @PostMapping("/addNew")
    public ResponseEntity<MoviePackDto> addNewPackage(MoviePackDto moviePackDto){
        return new ResponseEntity<>(packConverter.entityToDto(moviePackService.addPackage(moviePackDto)), HttpStatus.OK);
    }

    @GetMapping("/getById/{packId}")
    public ResponseEntity<MoviePackDto> getPackage(@PathVariable int packId){
        return new ResponseEntity<>(packConverter.entityToDto(moviePackService.getPackage(packId)), HttpStatus.OK);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<MoviePackDto> getPackage(@PathVariable String name){
        return new ResponseEntity<>(packConverter.entityToDto(moviePackService.getPackage(name)), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MoviePackDto>> getAll(){
        return new ResponseEntity<>(packConverter.entityToDto(moviePackService.getAll()), HttpStatus.OK);
    }

}
