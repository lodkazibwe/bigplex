package com.bigplex.bigplex.security;


import com.bigplex.bigplex.user.dao.ProfileDao;
import com.bigplex.bigplex.user.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    ProfileDao profileDao;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Profile user =getUser(userName);
        MyUserDetails userDetails=new MyUserDetails(user);
        if(user !=null){
            return userDetails;

        }else{
            throw new UsernameNotFoundException("User not exist with name : " + userName);
        }
    }

    public Profile getUser(String userName){
        return profileDao.findByUserName(userName);
    }


    public Profile currentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName=auth.getName();
        return  getUser(userName);
    }
}
