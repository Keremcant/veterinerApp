package com.example.veterinerApp;

import com.example.veterinerApp.constant.Constant;
import com.example.veterinerApp.model.User;
import com.example.veterinerApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;



@Component
public class DatabaseSeeder implements ApplicationRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder pe;

	public DatabaseSeeder(UserRepository userRepository) { this.userRepository = userRepository; }

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (userRepository.findAll().size() == 0){
			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword(pe.encode("admin"));
			admin.setRole(Constant.ROLE_ADMIN);

			User veterinary = new User();
			veterinary.setUsername("veterinary");
			veterinary.setPassword(pe.encode("vett"));
			veterinary.setRole(Constant.ROLE_VETERINARY);

			userRepository.save(admin);
			userRepository.save(veterinary);
		}
	}
	


	
}
