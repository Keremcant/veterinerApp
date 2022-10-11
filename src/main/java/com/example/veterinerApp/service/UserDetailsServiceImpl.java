package com.example.veterinerApp.service;

import com.example.veterinerApp.model.MyUserDetails;
import com.example.veterinerApp.model.User;
import com.example.veterinerApp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User veterinary = userRepository.findByUsername(username);

        if (username == null) {
            throw new UsernameNotFoundException("Kullanıcı bulunumadı!");
        }

        return new MyUserDetails(veterinary);
    }
}
