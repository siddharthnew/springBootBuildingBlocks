package com.stackSimplify.restServices.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackSimplify.restServices.entities.Order;
import com.stackSimplify.restServices.entities.User;
import com.stackSimplify.restServices.exceptions.UserNotFoundException;
import com.stackSimplify.restServices.repositry.OrderRepositry;
import com.stackSimplify.restServices.repositry.UserRepositry;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

	
	@Autowired
	private UserRepositry userRepositry;
	@Autowired
	private OrderRepositry orderRepositry;
	//get all orders from an user
	@GetMapping("/{userId}/orders")
	public List<Order> getAllOrders(@PathVariable Long userId) throws UserNotFoundException {
		Optional<User>userOptional=userRepositry.findById(userId);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		return userOptional.get().getOrders();
	}
	@PostMapping("{userId}/orders")
	public Order createOrder(@PathVariable Long userId, @RequestBody Order order) throws UserNotFoundException {
		
		Optional<User> userOptional = userRepositry.findById(userId);
		if(!userOptional.isPresent()) {
		  throw new UserNotFoundException("User Not exists");	
		}
		User user =userOptional.get();
		order.setUser(user);
		return orderRepositry.save(order);
	}
	@GetMapping("{userId}/orders/{orderId}")
	public Order getOrderByOrderId(@PathVariable Long userId, @PathVariable Long orderId) throws UserNotFoundException {

		Optional<User> userOptional = userRepositry.findById(userId);
		if(!userOptional.isPresent()) {
		  throw new UserNotFoundException("User Not exists");	
		}
		User user =userOptional.get();
		List<Order> listorder=user.getOrders().stream().filter(order->order.getOrderId().compareTo(orderId)==0.0)
				.collect(Collectors.toCollection(ArrayList::new));
		return listorder.get(0);
		
	}
}
