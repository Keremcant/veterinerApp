package com.example.veterinerApp.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class MyUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    private User veterinary;

    public MyUserDetails(User veterinary){ this.veterinary = veterinary;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(veterinary.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword(){ return veterinary.getPassword();}

    @Override
    public String getUsername() { return veterinary.getUsername(); }

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
