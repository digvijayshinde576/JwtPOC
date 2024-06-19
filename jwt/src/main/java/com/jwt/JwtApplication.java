package com.jwt;

import com.jwt.entity.User;
import com.jwt.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.PushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtApplication {

	@Autowired
	private UserRepository userRepository;
@PostConstruct
	public void inItUSer(){
		List<User> userList= Stream.of(
				new User(101,"digvijay","password","digvijay@gmail.com"),
				new User(102,"rohit","password","rohit@gmail.com"),
		new User(103,"rahul","password","rahul@gmail.com"),
		new User(104,"vijay","password","vijay@gmail.com")


		).collect(Collectors.toList());
		userRepository.saveAll(userList);
	}


	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

}
