package com.jwt.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig  {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin= User.withUsername("digvijay")
                .password(encoder.encode("password"))
                .roles("admin")
                .build();
        UserDetails user= User.withUsername("sanjay")
                .password(encoder.encode("password"))
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(admin,user);

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

      return   http..disable()
                .authorizeHttpRequests()
              .requestMatchers("/user/welcome")
              .permitAll()
              .and()
              .authorizeHttpRequests("/user/**")
              .build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf-> csrf.disable())
                .authorizeRequests(auth->auth.requestMatchers(  "/user/welcome").permitAll().anyRequest().authenticated())
                .authorizeHttpRequests(auth->auth.requestMatchers("/user/**").) // Example: Requires authentication for /user/** endpoints
                ; // Example: Requires authentication for all other endpoints
        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }
}
