package com.example.veterinerApp.config;

import com.example.veterinerApp.constant.Constant;
import com.example.veterinerApp.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/admin/**").hasAnyAuthority(Constant.ROLE_ADMIN)
                .antMatchers("/owners/**").hasAnyAuthority(Constant.ROLE_ADMIN, Constant.ROLE_VETERINARY)
                .antMatchers("/search/**").hasAnyAuthority(Constant.ROLE_ADMIN, Constant.ROLE_VETERINARY)
                .antMatchers("pets/**").hasAnyAuthority(Constant.ROLE_VETERINARY)
                .antMatchers("/").permitAll()

                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll();



    }

}
