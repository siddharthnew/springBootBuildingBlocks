package com.stackSimplify.restServices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackSimplify.restServices.entities.User;
import com.stackSimplify.restServices.services.UserService;

@RestController
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
	public User createUser(@RequestBody User user) {
		System.out.println("Enter create");
		return userService.createUser(user);
	}

	// get user by id
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);

	}

	// updateBy Id
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
		return userService.updateUserById(id, user);
	}

//delete
	@DeleteMapping("delete/{id}")
	public void deleteUserById(@PathVariable("id")Long id) {
		userService.deleteUserById(id);
	}

	//find user by Username
	@GetMapping("/users/byUserName/{username}")
	public User getUserByUserName(@PathVariable("username") String userName) {
		return userService.getUserByUserName(userName);
	}
}
