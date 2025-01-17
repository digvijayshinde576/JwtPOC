package com.jwt.service;

import com.jwt.entity.User;
import com.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {
  @Autowired
   private UserRepository userRepository;
    public List<User> getAll(){
        return  userRepository.findAll();
    }


}
