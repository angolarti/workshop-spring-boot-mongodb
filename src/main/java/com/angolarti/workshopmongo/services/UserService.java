package com.angolarti.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angolarti.workshopmongo.domain.User;
import com.angolarti.workshopmongo.dto.UserDTO;
import com.angolarti.workshopmongo.repository.UserRepository;
import com.angolarti.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository; //CDI do Spring

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
//		User user = userRepository.findById(id).get();
//		if (user == null ) {
//			throw new ObjectNotFoundException("Objeto não encontrado");
//		}
//		return user;

		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User user) {
		return userRepository.insert(user);
	}

	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}

	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
}
