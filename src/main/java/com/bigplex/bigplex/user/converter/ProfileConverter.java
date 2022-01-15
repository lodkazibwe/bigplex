package com.bigplex.bigplex.user.converter;

import com.bigplex.bigplex.user.dto.ProfileDto;
import com.bigplex.bigplex.user.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfileConverter {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public ProfileDto entityToDto(Profile profile){
        ProfileDto profileDto = new ProfileDto();
        profileDto.setContact(profile.getContact());
        profileDto.setImage(profile.getImage());
        profileDto.setName(profile.getName());
        profileDto.setUserId(profile.getUserId());
        profileDto.setUserName(profile.getUserName());
        profileDto.setUserStatus(profile.getUserStatus());
        return profileDto;
    }

    public Profile dtoToEntity(ProfileDto profileDto){
        Profile profile =new Profile();
        profile.setContact(profileDto.getContact());
        profile.setImage(profileDto.getImage());
        profile.setName(profileDto.getName());
        profile.setPassword(passwordEncoder.encode("123abc"));
        profile.setUserName(profileDto.getUserName());
        profile.setUserStatus(profileDto.getUserStatus());
        return profile;
    }

    public List<ProfileDto> entityToDto(List<Profile> profileList){
        return profileList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<Profile> dtoToEntity(List<ProfileDto> profileDtoList){
        return profileDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

}
