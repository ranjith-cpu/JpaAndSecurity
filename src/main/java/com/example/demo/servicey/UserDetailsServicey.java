package com.example.demo.servicey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.EntityDetails;
import com.example.demo.repo.DbsRepo;

@Service
public class UserDetailsServicey implements UserDetailsService{
    
    @Autowired
    DbsRepo dBUserRepo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        EntityDetails dBUserEntity = dBUserRepo.findByUserName(username);
        
        EntityuserDetailsService dBSUserDetails = new EntityuserDetailsService(dBUserEntity);
        
        List<GrantedAuthority> authorityList = (List<GrantedAuthority>) dBSUserDetails.getAuthorities();
        
        return dBSUserDetails;
    }
}
