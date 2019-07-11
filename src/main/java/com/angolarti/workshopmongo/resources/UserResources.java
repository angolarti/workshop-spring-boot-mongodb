package com.angolarti.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angolarti.workshopmongo.domain.User;
import com.angolarti.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResources {

	@Autowired
	private UserService userService;

	@RequestMapping(method=RequestMethod.GET) // @GetMApping
	public ResponseEntity<List<User>> findAll() {
//		User maria = new User("1", "Maria Brown", "maria@gmail.com");
//		User alex = new User("2", "Alex Green", "alex@gmail.com");
		
//		List<User> list = new ArrayList<>();
//		list.addAll(Arrays.asList(maria, alex));
		
		List<User> list = userService.findAll();

		return ResponseEntity.ok().body(list); // Return a instance de responseEntinty with headers http
	}
}
