package com.bigplex.bigplex.moviePackage.dao;

import com.bigplex.bigplex.moviePackage.model.MoviePack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviePackDao extends JpaRepository<MoviePack, Integer> {
    MoviePack findByName(String name);

    boolean existsByName(String name);

}
