package com.bigplex.bigplex.order.dao;

import com.bigplex.bigplex.order.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer> {
}
