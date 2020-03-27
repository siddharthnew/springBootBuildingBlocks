package com.stackSimplify.restServices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackSimplify.restServices.entities.User;
import com.stackSimplify.restServices.repositry.UserRepositry;

@Service
public class UserService {
//Autowire the UsereRepositry.
	
	@Autowired
	private UserRepositry userRepositry;
	
	//getAllUsers method
	public List<User> getAllUsers() {
		return userRepositry.findAll();
	}
	
	//create user method
	public User createUser(User user) {
		return userRepositry.save(user);
	}
	
	//create getuserById
	 public Optional<User> getUserById(Long id) {
		 Optional<User> findById = userRepositry.findById(id);
		return findById;
		
	 }
	 //update userByid
	 public User updateUserById(Long id,User user) {
		 user.setId(id);
		 return userRepositry.save(user);
	 }
	//delete
	 public void deleteUserById(Long id) {
		 if(userRepositry.findById(id).isPresent()) {
			  userRepositry.deleteById(id);
		 }
		
	 }
	 
	 // finduserbyUsername
	 
	 public User getUserByUserName(String username) {
		  return userRepositry.findByUserName(username);
	 }
	 
	 
	 
	 
	 
}
