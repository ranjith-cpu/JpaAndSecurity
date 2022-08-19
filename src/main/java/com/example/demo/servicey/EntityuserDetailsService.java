package com.example.demo.servicey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.EntityDetails;

public class EntityuserDetailsService  implements UserDetails{
	    
	    String userName;
	    String password;
	    String roles;
	    List<GrantedAuthority> authorityList;
	    public EntityuserDetailsService (EntityDetails dBUserEntity) {
	    
	        this.userName = dBUserEntity.getUserName();
	        this.password = dBUserEntity.getPassword();
	        this.roles = dBUserEntity.getRoles();
	        
	        String[] allRoles = roles.split(":");
	        String eachRole = "";
	        List<GrantedAuthority> localAuthorityList = new ArrayList<GrantedAuthority>();
	        
	        for(int i=0;i<allRoles.length;i++) {
	            eachRole = allRoles[i];
	            
	            localAuthorityList.add(new SimpleGrantedAuthority(eachRole));
	            
	        }
	        
	        this.authorityList = localAuthorityList;
	    }
	    public EntityuserDetailsService() {
	        // TODO Auto-generated constructor stub
	    }
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorityList;
	    }
	    @Override
	    public String getPassword() {
	        return password;
	    }
	    @Override
	    public String getUsername() {
	    	
	    	return userName;

	    }
	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }
	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	    @Override
	    public boolean isEnabled() {
	        return true;
	    }
	    
}
