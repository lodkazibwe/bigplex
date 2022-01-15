package com.bigplex.bigplex.moviePackage.service;

import com.bigplex.bigplex.moviePackage.dto.MoviePackDto;
import com.bigplex.bigplex.moviePackage.model.MoviePack;

import java.util.List;

public interface MoviePackService {
    MoviePack addPackage(MoviePackDto moviePackDto);
    MoviePack getPackage(int packId);
    MoviePack getPackage(String  name);
    boolean packExists(String name);
    List<MoviePack> getAll();

}
