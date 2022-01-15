package com.bigplex.bigplex.user.service.impl;

import com.bigplex.bigplex.exceptions.InvalidValuesException;
import com.bigplex.bigplex.exceptions.ResourceNotFoundException;
import com.bigplex.bigplex.user.converter.ProfileConverter;
import com.bigplex.bigplex.user.dao.ProfileDao;
import com.bigplex.bigplex.user.dto.ProfileDto;
import com.bigplex.bigplex.user.model.Profile;
import com.bigplex.bigplex.user.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired ProfileDao profileDao;
    @Autowired ProfileConverter profileConverter;

    @Override
    public Profile addUser(ProfileDto profileDto) {
        boolean bool =userExists(profileDto.getUserName(), profileDto.getContact());
        if(bool){
            throw new InvalidValuesException("username or contact already used");
        }
        return profileDao.save(profileConverter.dtoToEntity(profileDto));
    }

    @Override
    public Profile getUser(int userId) {
        return profileDao.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("No such user With ID: " +userId));
    }

    @Override
    public Profile getUser(String userName) {
        return profileDao.findByUserName(userName);
    }

    @Override
    public Profile getByContact(String contact) {
        return profileDao.findByContact(contact);
    }

    @Override
    public boolean userExists(String userName) {
        return profileDao.existsByUserName(userName);
    }

    @Override
    public boolean userExists(String userName, String contact) {
        return profileDao.existsByUserNameOrContact(userName, contact);
    }

    @Override
    public Profile updateUser(ProfileDto profileDto) {
        return null;
    }

    @Override
    public List<Profile> getAll() {
        return profileDao.findAll();
    }
}
