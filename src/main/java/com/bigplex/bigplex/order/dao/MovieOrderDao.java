package com.bigplex.bigplex.order.dao;

import com.bigplex.bigplex.order.model.MovieOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieOrderDao extends JpaRepository<MovieOrder, Integer> {
}
