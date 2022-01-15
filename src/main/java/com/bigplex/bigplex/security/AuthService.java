package com.bigplex.bigplex.security;

import com.bigplex.bigplex.exceptions.InvalidValuesException;
import com.bigplex.bigplex.user.converter.ProfileConverter;
import com.bigplex.bigplex.user.model.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    ProfileConverter profileConverter;

    private final Logger logger = LoggerFactory.getLogger(AuthService.class);

    public String getJwt(AuthRequest authRequest, HttpServletRequest request){
        try {
            logger.info("authenticating....");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception e) {
            logger.info("invalid user name or pass....");
            throw new InvalidValuesException("Incorrect name or password");

        }
        logger.info("getting user details....");
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(authRequest.getUserName());
        logger.info("getting token....");
        logger.info("authenticated....");
        Profile user =myUserDetailsService.getUser(authRequest.getUserName());
       return jwtUtil.generateToken(userDetails);


    }

    public boolean checkUser(AuthRequest authRequest){
        try {
            logger.info("checking auth....");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception e) {
            logger.info("invalid pass....");
            throw new InvalidValuesException("Incorrect old password");

        }
        return true;
    }

    public AuthResponse authenticate(AuthRequest authRequest, HttpServletRequest request){
        String jwt =getJwt(authRequest, request);
        Profile profile =myUserDetailsService.getUser(authRequest.getUserName());
        return new AuthResponse(jwt, profileConverter.entityToDto(profile));

    }

}
