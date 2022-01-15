package com.bigplex.bigplex.user.service;

import com.bigplex.bigplex.user.dto.ProfileDto;
import com.bigplex.bigplex.user.model.Profile;

import java.util.List;

public interface ProfileService {
    Profile addUser(ProfileDto profileDto);
    Profile getUser(int id);
    Profile getUser(String userName);
    Profile getByContact(String contact);
    boolean userExists(String userName);
    boolean userExists(String userName, String contact);
    Profile updateUser(ProfileDto profileDto);
    List<Profile> getAll();

}
