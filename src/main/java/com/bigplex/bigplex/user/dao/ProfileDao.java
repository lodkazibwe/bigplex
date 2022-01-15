package com.bigplex.bigplex.user.dao;

import com.bigplex.bigplex.user.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileDao extends JpaRepository<Profile, Integer> {
    Profile findByUserName(String userName);

    Profile findByContact(String contact);

    boolean existsByUserName(String userName);

    boolean existsByUserNameOrContact(String userName, String Contact);
}
