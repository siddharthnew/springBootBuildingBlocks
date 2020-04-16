package com.stackSimplify.restServices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stackSimplify.restServices.entities.User;
import com.stackSimplify.restServices.exceptions.SSNExistsException;
import com.stackSimplify.restServices.exceptions.UserExistsException;
import com.stackSimplify.restServices.exceptions.UserNotFoundException;
import com.stackSimplify.restServices.repositry.UserRepositry;

@Service
public class UserService {
//Autowire the UsereRepositry.
	
	@Autowired
	private UserRepositry userRepositry;
	private User userExistsByName;
	private User userExistsBySsn;
	
	//getAllUsers method
	public List<User> getAllUsers() {
		return userRepositry.findAll();
	}
	
	//create user method
	public User createUser(User user) throws UserExistsException, SSNExistsException {
		userExistsByName = userRepositry.findByUserName(user.getUserName());
		userExistsBySsn=userRepositry.findBySsn(user.getSsn());
		if(userExistsByName!=null) {
			throw new UserExistsException("User Already Exists. Cannot create a duplicate user.try with another username");
		}
		/*
		 * if(userExistsBySsn!=null) { throw new
		 * SSNExistsException("SSN should be unique. Cannot cfreate aduplicate ssn, try with differen ssn"
		 * ); }
		 */
		return userRepositry.save(user);
	}
	
	//create getuserById
	 public Optional<User> getUserById(Long id) throws UserNotFoundException {
		 Optional<User> findById = userRepositry.findById(id);
		 if(!findById.isPresent()) {
			 throw new UserNotFoundException("User not Found In Repositry");
		 }
		return findById;
		
	 }
	 //update userByid
	 public User updateUserById(Long id,User user) throws UserNotFoundException {
		 Optional<User> optionalUser = userRepositry.findById(id);
		 if(!optionalUser.isPresent()) {
			 throw new UserNotFoundException("User not Found In Repositry, please provide a correct userId");
		 }
		 user.setId(id);
		 return userRepositry.save(user);
	 }
	//delete
	 public void deleteUserById(Long id) {
		 Optional<User> optionalUser = userRepositry.findById(id);
		 if(!optionalUser.isPresent()) {
			 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not Found In Repositry, please provide a correct userId	");
		 }
		 userRepositry.deleteById(id);
		
	 }
	 
	 // finduserbyUsername
	 
	 public User getUserByUserName(String username) {
		  return userRepositry.findByUserName(username);
	 }
	 
	 
	 
	 
	 
}
