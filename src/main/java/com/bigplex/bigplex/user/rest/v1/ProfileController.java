package com.bigplex.bigplex.user.rest.v1;

import com.bigplex.bigplex.user.converter.ProfileConverter;
import com.bigplex.bigplex.user.dto.ProfileDto;
import com.bigplex.bigplex.user.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class ProfileController {
    @Autowired ProfileService profileService;
    @Autowired ProfileConverter profileConverter;
    private final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @PostMapping("/new")
    public ResponseEntity<ProfileDto> addUser(@Valid @RequestBody ProfileDto profileDto){
        logger.info("starting...");
        return new ResponseEntity<>(profileConverter.entityToDto(profileService.addUser(profileDto)), HttpStatus.OK);

    }
    @GetMapping("/getById/{userId}")
    public ResponseEntity<ProfileDto> getUser(@PathVariable int userId){
        return new ResponseEntity<>(profileConverter.entityToDto(profileService.getUser(userId)), HttpStatus.OK);

    }
    @GetMapping("/getByName/{userName}")
    public ResponseEntity<ProfileDto> getUser(@PathVariable String userName){
        return new ResponseEntity<>(profileConverter.entityToDto(profileService.getUser(userName)), HttpStatus.OK);

    }
    @GetMapping("/getByContact/{contact}")
    public ResponseEntity<ProfileDto> getByContact(@PathVariable String contact){
        return new ResponseEntity<>(profileConverter.entityToDto(profileService.getByContact(contact)), HttpStatus.OK);

    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ProfileDto>> getAll(){
        return new ResponseEntity<>(profileConverter.entityToDto(profileService.getAll()), HttpStatus.OK);
    }

}
