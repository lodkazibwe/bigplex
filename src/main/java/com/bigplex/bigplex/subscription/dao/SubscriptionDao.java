package com.bigplex.bigplex.subscription.dao;

import com.bigplex.bigplex.subscription.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionDao extends JpaRepository<Subscription, Integer> {

    List<Subscription> findByUserId(int userId);

    List<Subscription> findByPackId(int packId);

}
