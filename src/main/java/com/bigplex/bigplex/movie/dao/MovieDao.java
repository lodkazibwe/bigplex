package com.bigplex.bigplex.movie.dao;

import com.bigplex.bigplex.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {

    Movie findByTitle(String title);

    boolean existsByTitle(String title);

    List<Movie> findByCategory(String category);

}
