package com.bigplex.bigplex.moviePackage.Converter;


import com.bigplex.bigplex.moviePackage.dto.MoviePackDto;
import com.bigplex.bigplex.moviePackage.model.MoviePack;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PackConverter {
    public MoviePackDto entityToDto(MoviePack moviePack){
        MoviePackDto moviePackDto =new MoviePackDto();
        moviePackDto.setPackId(moviePack.getPackId());
        moviePackDto.setDuration(moviePack.getDuration());
        moviePackDto.setName(moviePack.getName());
        moviePackDto.setPackStatus(moviePack.getPackStatus());
        moviePackDto.setPrice(moviePack.getPrice());
        moviePackDto.setSize(moviePack.getSize());
        return moviePackDto;

    }

    public MoviePack dtoToEntity(MoviePackDto moviePackDto){
        MoviePack moviePack =new MoviePack();
        moviePack.setDuration(moviePackDto.getDuration());
        moviePack.setName(moviePackDto.getName());
        moviePack.setPackStatus(moviePackDto.getPackStatus());
        moviePack.setPrice(moviePackDto.getPrice());
        moviePack.setSize(moviePackDto.getSize());
        return moviePack;
    }

    public List<MoviePackDto> entityToDto(List<MoviePack> moviePackList){
        return moviePackList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<MoviePack> dtoToEntity(List<MoviePackDto> moviePackDtoList){
        return moviePackDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

}
