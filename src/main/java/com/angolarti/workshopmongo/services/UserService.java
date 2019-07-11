package com.angolarti.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angolarti.workshopmongo.domain.User;
import com.angolarti.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository; //CDI do Spring

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
}
