package com.stackSimplify.restServices.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.stackSimplify.restServices.entities.User;
import com.stackSimplify.restServices.exceptions.UserExistsException;
import com.stackSimplify.restServices.exceptions.UserNameNotFoundException;
import com.stackSimplify.restServices.exceptions.UserNotFoundException;
import com.stackSimplify.restServices.services.UserService;

@RestController
@Validated
public class UserController {

	// Autowired the userservice
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();

	}

	// create user method
	@PostMapping("/createUsers")
	public ResponseEntity<Void> createUser(@Valid @RequestBody User user,UriComponentsBuilder builder) {
		try {
		   userService.createUser(user);
		   HttpHeaders headers=new HttpHeaders();
		   //headers.setLocation(builder.path("/createUsers/{id}").buildAndExpand(user.getId()).toUri());
		   headers.setLocation(builder.path("/createUsers/{id}").buildAndExpand(user.getId()).toUri());
		   return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		} catch (UserExistsException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
	}
	}
	// get user by id
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			return userService.getUserById(id);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}

	}

	// updateBy Id
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
		try {
			return userService.updateUserById(id, user);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

//delete
	@DeleteMapping("delete/{id}")
	public void deleteUserById(@PathVariable("id")Long id) {
		userService.deleteUserById(id);
	}

	//find user by Username
	@GetMapping("/users/byUserName/{username}")
	public User getUserByUserName(@PathVariable("username") String userName) throws UserNameNotFoundException {
		
		User user = userService.getUserByUserName(userName);
		if(null==user) {
			throw new UserNameNotFoundException("User Name Not found ");
		}
		return user;
	}
}
