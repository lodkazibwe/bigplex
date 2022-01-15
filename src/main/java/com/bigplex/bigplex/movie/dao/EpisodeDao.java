package com.bigplex.bigplex.movie.dao;

import com.bigplex.bigplex.movie.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeDao extends JpaRepository<Episode, Integer> {
}
