package com.stackSimplify.restServices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

	//Simple method
	//URI -helloWorld
	//Get
	@RequestMapping(method = RequestMethod.GET,path="/helloworld")
	
	public String helloWorld() {
		return "HelloWorld";
	}

	@GetMapping("/helloWorldBean")
	public UserDetails helloWorldBean() {

		return new UserDetails("Siddharth", "Trivedi", "Bangalore");

	}
}
